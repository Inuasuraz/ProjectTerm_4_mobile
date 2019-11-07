package buu.informatics.s59160081.projectterm_4.screens.screens.game

import android.app.Application
import android.os.Handler
import android.util.Log
import androidx.lifecycle.*
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.screens.database.GameScore
import buu.informatics.s59160081.projectterm_4.screens.database.GameScoreDatabaseDao
import kotlinx.coroutines.*
import java.util.*

class GameViewModel(val database: GameScoreDatabaseDao, application: Application) : AndroidViewModel(application) {

    val _eventChooseFinish = MutableLiveData<Boolean>()
    val eventChooseFinish: LiveData<Boolean>
        get() = _eventChooseFinish

    val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    val _eventTimeFinish = MutableLiveData<Boolean>()
    val eventTimeFinish: LiveData<Boolean>
        get() = _eventTimeFinish

    val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    val _round = MutableLiveData<Int>()
    val round: LiveData<Int>
        get() = _round

    val _ImageNumber = MutableLiveData<Int>()
    val ImageNumber: LiveData<Int>
        get() = _ImageNumber

    val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private var viewModelJob = Job()

    private val allScore = database.getAllGameScore()

    private var gameScore = MutableLiveData<GameScore?>()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        Log.i("MainViewModel", "MainViewModel created!")
        _eventChooseFinish.value = false
        _score.value = 0
        _round.value = 0
        _name.value = ""
        _ImageNumber.value = 0
        _eventGameFinish.value = false
        clearS()
        initializeGameScore()
    }

     fun checkAnswer(num : Int) {

         Log.i("CheckAns", "${num}")

            var randomInt = Random().nextInt(9) + 1

            val drawableResource = when (randomInt) {
                1 -> R.drawable.num_1
                2 -> R.drawable.num_2
                3 -> R.drawable.num_3
                4 -> R.drawable.num_4
                5 -> R.drawable.num_5
                6 -> R.drawable.num_6
                7 -> R.drawable.num_7
                8 -> R.drawable.num_8
                else -> R.drawable.num_9
            }

         _ImageNumber.value = drawableResource

         if (num == randomInt) {
             _score.value = _score.value!! + 1
         }

         _eventChooseFinish.value = true
    }

    fun timerCheck(){
        val handler = Handler()
        handler.postDelayed({
            // do something after 1000ms
            _round.value = _round.value!! + 1
            if (_round.value == 10){
                insertScore(_name.value!!, _score.value!!)
                _eventGameFinish.value = true
            }
                _eventTimeFinish.value = true
        }, 1000)
    }

    fun insertScore(username: String, score: Int) {
        uiScope.launch {
            val newScore = GameScore()
            newScore.username = username
            newScore.score = score
            insert(newScore)
        }
    }

    fun clearS() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun getGameScoreFromDatabase(): GameScore? {
        return withContext(Dispatchers.IO) {
            var score = database.getGameScore()
            score
        }
    }

    private fun initializeGameScore() {
        uiScope.launch {
            gameScore.value = getGameScoreFromDatabase()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun insert(score: GameScore) {
        withContext(Dispatchers.IO) {
            database.insert(score)
        }
    }


}
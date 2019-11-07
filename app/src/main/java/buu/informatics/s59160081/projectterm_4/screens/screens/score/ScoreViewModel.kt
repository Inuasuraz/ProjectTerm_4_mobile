package buu.informatics.s59160081.projectterm_4.screens.screens.score

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import buu.informatics.s59160081.projectterm_4.screens.database.GameScore
import buu.informatics.s59160081.projectterm_4.screens.database.GameScoreDatabaseDao
import kotlinx.coroutines.*

class ScoreViewModel(val database: GameScoreDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val _eventInputFinish = MutableLiveData<Boolean>()
    val eventInputFinish: LiveData<Boolean>
        get() = _eventInputFinish

    private var viewModelJob = Job()

    private var gameScore = MutableLiveData<GameScore?>()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val score = database.getAllGameScore()


    init {
        _eventInputFinish.value = false
        initializeGameScore()
    }

    fun backToMain(){
        _eventInputFinish.value = true
        Log.i("SSSS","ASD")
    }

    private fun initializeGameScore() {
        uiScope.launch {
            gameScore.value = getGameScoreFromDatabase()
        }
    }

    private suspend fun getGameScoreFromDatabase(): GameScore? {
        return withContext(Dispatchers.IO) {
            var score = database.getGameScore()
            score
        }
    }

}
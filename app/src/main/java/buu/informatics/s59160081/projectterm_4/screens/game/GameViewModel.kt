package buu.informatics.s59160081.projectterm_4.screens.game

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160081.projectterm_4.R
import buu.informatics.s59160081.projectterm_4.databinding.FragmentGameBinding
import java.util.*

class GameViewModel : ViewModel() {

//    private var question = 0
//    private var round = 0
//    private var ans = 0

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

    init {
        Log.i("MainViewModel", "MainViewModel created!")
        _eventChooseFinish.value = false
        _score.value = 0
        _round.value = 0
        _ImageNumber.value = 0
        _eventGameFinish.value = false
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
                _eventGameFinish.value = true
            }
                _eventTimeFinish.value = true
        }, 1000)
    }


}
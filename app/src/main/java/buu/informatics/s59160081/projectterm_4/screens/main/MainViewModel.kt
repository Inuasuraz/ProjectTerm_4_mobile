package buu.informatics.s59160081.projectterm_4.screens.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel(){

    val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventInputFinish = MutableLiveData<Boolean>()
    val eventInputFinish: LiveData<Boolean>
        get() = _eventInputFinish

    val _checkNameProcess = MutableLiveData<Boolean>()
    val checkNameProcess: LiveData<Boolean>
        get() = _checkNameProcess

    init {
        Log.i("MainViewModel", "MainViewModel created!")
        _score.value = 0
        _eventInputFinish.value = false
        _eventInputFinish.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun checkInput(){
        _eventInputFinish.value = true
    }

    fun checkName(name : String){
        Log.i("TEST", "user ${name}" )
            if (name.length >= 4 && name.length <= 8) {

                var username = name
                var userscore = 0

                Log.i("MainFragment", "Username : ${username}")
                Log.i("MainFragment", "Userscore : ${userscore}")

                _checkNameProcess.value = true
            }
    }
}
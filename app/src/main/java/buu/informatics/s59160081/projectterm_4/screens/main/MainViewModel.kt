package buu.informatics.s59160081.projectterm_4.screens.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _name = MutableLiveData<String>()
    val name: MutableLiveData<String>
        get() = _name
    private val _score = MutableLiveData<Int>()
    val score: MutableLiveData<Int>
        get() = _score

    init {
        Log.i("MainViewModel", "MainViewModel created!")
        _name.value = ""
        _score.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    fun updateName(update: String) {
        _name.value = update
    }

    fun getUserName(): LiveData<String> {
        return _name
    }


}
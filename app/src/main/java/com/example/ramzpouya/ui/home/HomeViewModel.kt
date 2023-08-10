package com.example.ramzpouya.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "password"
    }

    private val _lowerCase  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val _numbers = "0123456789"
    private val _specialChars = "!@#$%&*-_"


    private val _charCount = 8
    private val _numberCount = 3
    private val _specialCount = 3

    fun generateRand(){
        val length = _charCount + _numberCount + _specialCount
        var pass1 = ""
        for (i in 1.._charCount)
            pass1 += _lowerCase.random()
        var pass2 = ""
        for(i in 1.._numberCount)
            pass2 += _numbers.random()
        var pass3 = ""
        for(i in 1.._specialCount)
            pass3 += _specialChars.random()

        var pass = pass1 + pass2 + pass3
        Log.i("Log1", "pass is  : " + pass)
        pass = shuffle(pass)!!
        //pass = Collections.shuffle(pass.toList()).toString()
        _text.value = pass

    }

    fun shuffle(text: String): String? {
        val characters = text.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)
    }

    val text: LiveData<String> = _text
}
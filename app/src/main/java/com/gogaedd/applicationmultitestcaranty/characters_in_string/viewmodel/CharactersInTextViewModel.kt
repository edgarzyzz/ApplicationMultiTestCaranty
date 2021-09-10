package com.gogaedd.applicationmultitestcaranty.characters_in_string.viewmodel

import androidx.lifecycle.ViewModel
import com.gogaedd.applicationmultitestcaranty.characters_in_string.repository.CharactersInTextRepository

class CharactersInTextViewModel() : ViewModel() {
    private val repository = CharactersInTextRepository()

    private val lvdLetters = repository.getLvdLetters()


    fun getLvdLetters() = lvdLetters

    fun countLetters(text:String){
        repository.count(text)
    }


}
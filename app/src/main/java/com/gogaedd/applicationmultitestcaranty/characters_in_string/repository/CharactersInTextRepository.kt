package com.gogaedd.applicationmultitestcaranty.characters_in_string.repository

import android.os.Build
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.HashMap

class CharactersInTextRepository {
    private val mLvdLetters = MutableLiveData<String>("")
    fun getLvdLetters() = mLvdLetters



    fun count(text:String){
        val toCharArray = text.toCharArray()
        var textCountLetters =""

        val map : HashMap<String,Int> = hashMapOf()
        toCharArray.forEach {
            val letter = it.toString()
            if (map.containsKey(letter)){
                var value = map.get(letter)
                map[letter] = value!! +1
            }else{
                map.put(letter,1)
            }

        }

        val mapOrder = TreeMap<String,Int>(map)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mapOrder.forEach{ key, value->
                textCountLetters+= "$key: $value \n"


            }
        }else{
            var text = mapOrder.toString()
            val split = text.split(",")
            split.forEach{
                textCountLetters += "$it\n"
            }
        }

        mLvdLetters.value = textCountLetters


//        mLvdMapLetters.value = mapOrder
//        map


    }


}
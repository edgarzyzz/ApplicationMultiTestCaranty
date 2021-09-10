package com.gogaedd.applicationmultitestcaranty.weather.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.gogaedd.applicationmultitestcaranty.weather.repository.WeatherRepository

class WeatherViewModel : ViewModel() {
    private val repository: WeatherRepository = WeatherRepository()
    private val lvdResponseWeather = repository.getLvdResponseWeather()
    private val lvdMessageError = repository.getLvdMessageError()

    fun getLvdResponseWeather() = lvdResponseWeather
    fun getLvdMessageError() = lvdMessageError

    fun startloadWeather(latitude: String, longitude: String) {
        repository.startRequestWeather(latitude, longitude)
    }


}
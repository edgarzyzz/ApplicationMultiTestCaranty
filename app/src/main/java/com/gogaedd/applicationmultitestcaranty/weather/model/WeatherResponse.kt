package com.gogaedd.applicationmultitestcaranty.weather.model

data class WeatherResponse(
    var lat: Double  = 0.0,
    var lon: Double = 0.0,
    var timezone: String = "",
    var current: Weather = Weather(),
    var hourly: MutableList<Weather> = mutableListOf()


)

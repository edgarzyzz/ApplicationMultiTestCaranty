package com.gogaedd.applicationmultitestcaranty.weather.model

import com.google.gson.annotations.SerializedName

data class Weather(
    var dt : String ="",
    var temp : String ="",
    var humidity : String ="",
    var uvi : String ="",
    var clouds : String ="",
    var wind_speed : String ="",
    var wind_deg : String ="",
    @SerializedName("weather")
    var summaryWeather : MutableList<SummaryWeather> = mutableListOf(),

)

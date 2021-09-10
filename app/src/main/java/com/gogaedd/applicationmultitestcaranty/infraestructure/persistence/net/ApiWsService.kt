package com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net


import com.gogaedd.applicationmultitestcaranty.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWsService {

    @GET("data/2.5/onecall")
    fun getPerson(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") keyApiWeather: String): Call<WeatherResponse>


}
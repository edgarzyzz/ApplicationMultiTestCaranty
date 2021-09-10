package com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net

import android.util.Log
import com.gogaedd.applicationmultitestcaranty.infraestructure.ConstantsApp
import com.gogaedd.applicationmultitestcaranty.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetWeather(): NetHelper() {

    fun startRequestWeather(latitude: String, longitude:String){


        val call = apiService.getPerson(latitude, longitude, ConstantsApp.KEY_API_WEATHER)
        call.enqueue(object: Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        mListener?.onResultOk(it, ConstantsApp.Net.NET_WEATHER_GET)
                        return
                    }


                }
                mListener?.onResultError("Datos vacios",ConstantsApp.Net.NET_WEATHER_GET)


            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                mListener?.onResultError("Error: ${t.message}",ConstantsApp.Net.NET_WEATHER_GET)
            }
        })
    }
}
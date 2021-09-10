package com.gogaedd.applicationmultitestcaranty.weather.repository

import androidx.lifecycle.MutableLiveData
import com.gogaedd.applicationmultitestcaranty.infraestructure.ConstantsApp
import com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net.NetHelperListener
import com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net.NetWeather
import com.gogaedd.applicationmultitestcaranty.weather.model.WeatherResponse

class WeatherRepository(): NetHelperListener {
    private val netWeather = NetWeather()
    init {
        netWeather.setListener(this)
    }

    private val mLvdResponseWeather = MutableLiveData<WeatherResponse>(WeatherResponse())
    private val mLvdMessageError = MutableLiveData<String>()

    fun getLvdResponseWeather() = mLvdResponseWeather
    fun getLvdMessageError() = mLvdMessageError


    fun setresponseWeather(responseweather: WeatherResponse){
        mLvdResponseWeather.value = responseweather
    }

    fun startRequestWeather(latitude: String, longitude:String){
        netWeather.startRequestWeather(latitude,longitude)
    }



    override fun onResultOk(any: Any, code: Int) {

        when(code){
            ConstantsApp.Net.NET_WEATHER_GET->{
                setresponseWeather(any as WeatherResponse)
            }
            else->{}
        }
    }

    override fun onResultError(messageError: String, code: Int) {
        mLvdMessageError.value = messageError

    }


}
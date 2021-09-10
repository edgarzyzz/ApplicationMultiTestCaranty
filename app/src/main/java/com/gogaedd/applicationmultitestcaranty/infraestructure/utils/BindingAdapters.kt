package com.gogaedd.applicationmultitestcaranty.infraestructure.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gogaedd.applicationmultitestcaranty.R
import com.gogaedd.applicationmultitestcaranty.weather.Utils
import com.gogaedd.applicationmultitestcaranty.weather.adapter.WeatherHourAdapter
import com.gogaedd.applicationmultitestcaranty.weather.model.SummaryWeather
import com.gogaedd.applicationmultitestcaranty.weather.model.Weather

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("dataWeather")
    fun dataWeather(recycler: RecyclerView, listWeather: MutableList<Weather>){
        recycler.adapter?.let{adapterNotNull->

            if (adapterNotNull is WeatherHourAdapter){
                adapterNotNull.updateelements(listWeather)
            }
        }

    }

    @JvmStatic
    @BindingAdapter("drawImageWeather")
    fun drawImageWeather(imageView: ImageView, listSummaryWeather: MutableList<SummaryWeather>?) {

        if (listSummaryWeather.isNullOrEmpty()) return

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_cloud)
            .error(R.drawable.ic_cloud)

        listSummaryWeather[0].let {
            val img = it.icon
            val url = "http://openweathermap.org/img/wn/$img@2x.png"
            Glide.with(imageView.context)
                .load(url)
                .apply(options)
                .into(imageView)
        }

    }


    @JvmStatic
    @BindingAdapter("descDetail")
    fun descDetail(textView: TextView, listSummaryWeather: MutableList<SummaryWeather>?) {
        if (listSummaryWeather.isNullOrEmpty()) return

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_cloud)
            .error(R.drawable.ic_cloud)

        listSummaryWeather[0].let {
            textView.text = it.description
        }
    }

    @JvmStatic
    @BindingAdapter("paserDateTHour")
    fun paserDateTHour(textview: TextView, date :String){
        textview.text= Utils.dateToHours(date.toLong())

    }


    @JvmStatic
    @BindingAdapter("kelvinToCelsius")
    fun kelvinToCelsius(textView: TextView, kelvin:String){
        val CONST_KELVIN = 273.15
        textView.text = try {
            val currentKelvin = kelvin.toDouble()
             val temp=currentKelvin-CONST_KELVIN
            var tempString = temp.toString()

            if (tempString.length>=5){
                tempString = tempString.substring(0, 5)
            }
            "$tempString °C"




        } catch (e: Exception) {
            "$kelvin °k"
        }

    }

}
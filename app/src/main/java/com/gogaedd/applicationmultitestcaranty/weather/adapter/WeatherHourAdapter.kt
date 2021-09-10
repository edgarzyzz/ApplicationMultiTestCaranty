package com.gogaedd.applicationmultitestcaranty.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.applicationmultitestcaranty.databinding.ItemWeatherBinding
import com.gogaedd.applicationmultitestcaranty.weather.model.Weather

class WeatherHourAdapter() : RecyclerView.Adapter<WeatherHourAdapter.WeatherHourViewHolder>() {
    val mlistWeatherByHour = mutableListOf<Weather>()

    fun updateelements(listUpdated: MutableList<Weather>) {
        mlistWeatherByHour.clear()
        mlistWeatherByHour.addAll(listUpdated)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHourViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(inflater, parent, false)
        return WeatherHourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherHourViewHolder, position: Int) =
        holder.bind(mlistWeatherByHour[position])

    override fun getItemCount(): Int = mlistWeatherByHour.size

    class WeatherHourViewHolder(val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.weather = weather

        }

    }

}
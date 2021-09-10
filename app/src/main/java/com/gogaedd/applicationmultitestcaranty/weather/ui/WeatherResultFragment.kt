package com.gogaedd.applicationmultitestcaranty.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gogaedd.applicationmultitestcaranty.R
import com.gogaedd.applicationmultitestcaranty.databinding.FragmentWeatherResultBinding
import com.gogaedd.applicationmultitestcaranty.weather.adapter.WeatherHourAdapter
import com.gogaedd.applicationmultitestcaranty.weather.viewmodel.WeatherViewModel

class WeatherResultFragment : Fragment() {
    lateinit var viewModel: WeatherViewModel
    lateinit var binding: FragmentWeatherResultBinding
    private val args : WeatherResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)
        binding= FragmentWeatherResultBinding.inflate(inflater, container,false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner=viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvweatherHoursFgmntwe.apply {
            adapter = WeatherHourAdapter()
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }


        viewModel.startloadWeather(args.latitude,args.longitude)

    }


}
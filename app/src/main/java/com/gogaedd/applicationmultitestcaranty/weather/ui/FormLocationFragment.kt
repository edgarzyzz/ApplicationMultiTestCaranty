package com.gogaedd.applicationmultitestcaranty.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gogaedd.applicationmultitestcaranty.R
import com.gogaedd.applicationmultitestcaranty.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_form_location.*

class FormLocationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAcceptFgmntl.setOnClickListener {
            val lat = etLatFgmntfl.text.toString()
            val lon = etLonFgmntfl.text.toString()
            val action =
                FormLocationFragmentDirections.actionGoToWeatherResultFragment(
                    lat,
                    lon
                )
            findNavController().navigate(action)
        }
    }


}
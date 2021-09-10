package com.gogaedd.applicationmultitestcaranty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gogaedd.applicationmultitestcaranty.infraestructure.ConstantsApp
import com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net.ApiWsClient
import com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net.ApiWsService
import com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net.NetWeather
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
package com.gogaedd.applicationmultitestcaranty.weather

import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {
    fun dateToHours(date:Long): String? {





        return try {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = date*1000
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
             "$hour hrs"

        }catch (e :Exception){
            date.toString()
        }
    }
}
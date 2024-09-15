package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Forecast(

    @SerializedName("forecastday")
    @Expose
    val forecastday: ArrayList<Forecastday>

)
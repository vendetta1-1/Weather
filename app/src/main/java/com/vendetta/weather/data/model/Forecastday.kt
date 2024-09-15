package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Forecastday(

    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("date_epoch")
    @Expose
    val dateEpoch: Int,
    @SerializedName("day")
    @Expose
    val day: Day,
    @SerializedName("astro")
    @Expose
    val astro: Astro,
    @SerializedName("hour")
    @Expose
    val hour: ArrayList<Hour>

)
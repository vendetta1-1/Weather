package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Day(

    @SerializedName("maxtemp_c")
    @Expose
    val maxtempC: Double,
    @SerializedName("mintemp_c")
    @Expose
    val mintempC: Double,
    @SerializedName("daily_will_it_rain")
    @Expose
    val dailyWillItRain: Int,
    @SerializedName("daily_chance_of_rain")
    @Expose
    val dailyChanceOfRain: Int,
    @SerializedName("condition")
    @Expose
    val condition: Condition,
    @SerializedName("uv")
    @Expose
    val uv: Double

)
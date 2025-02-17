package com.vendetta.weather.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DayDto(

    @SerializedName("maxtemp_c")
    @Expose
    val maxTempC: Double,
    @SerializedName("mintemp_c")
    @Expose
    val minTempC: Double,
    @SerializedName("daily_will_it_rain")
    @Expose
    val dailyWillItRain: Int,
    @SerializedName("daily_chance_of_rain")
    @Expose
    val dailyChanceOfRain: Int,
    @SerializedName("condition")
    @Expose
    val condition: ConditionDto,
    @SerializedName("uv")
    @Expose
    val uv: Double

)
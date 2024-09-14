package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Main(

    @SerializedName("temp")
    @Expose
    private val temp: Double,
    @SerializedName("feels_like")
    @Expose
    private val feelsLike: Double,
    @SerializedName("temp_min")
    @Expose
    private val tempMin: Double,
    @SerializedName("temp_max")
    @Expose
    private val tempMax: Double,
    @SerializedName("pressure")
    @Expose
    private val pressure: Int,
    @SerializedName("humidity")
    @Expose
    private val humidity: Int,
    @SerializedName("sea_level")
    @Expose
    private val seaLevel: Int,
    @SerializedName("grnd_level")
    @Expose
    private val groundLevel: Int
)
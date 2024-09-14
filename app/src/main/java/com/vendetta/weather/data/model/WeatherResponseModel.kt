package com.vendetta.weather.data.model

import androidx.compose.runtime.Immutable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Immutable
data class WeatherResponseModel(
    @SerializedName("coord")
    @Expose
    private val coordinates: Coordinates,
    @SerializedName("weather")
    @Expose
    private val weather: List<Weather>,
    @SerializedName("base")
    @Expose
    private val base: String,
    @SerializedName("main")
    @Expose
    private val main: Main,
    @SerializedName("visibility")
    @Expose
    private val visibility: Int,
    @SerializedName("wind")
    @Expose
    private val wind: Wind,
    @SerializedName("clouds")
    @Expose
    private val clouds: Clouds,
    @SerializedName("dt")
    @Expose
    private val dt: Int,
    @SerializedName("sys")
    @Expose
    private val sys: Sys,
    @SerializedName("timezone")
    @Expose
    private val timezone: Int,
    @SerializedName("id")
    @Expose
    private val id: Int,
    @SerializedName("name")
    @Expose
    private val name: String,
    @SerializedName("cod")
    @Expose
    private val cod: Int
)
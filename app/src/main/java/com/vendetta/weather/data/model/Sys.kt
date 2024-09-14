package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sys(

    @SerializedName("type")
    @Expose
    private val type: Int,
    @SerializedName("id")
    @Expose
    private val id: Int,
    @SerializedName("country")
    @Expose
    private val country: String,
    @SerializedName("sunrise")
    @Expose
    private val sunrise: Int,
    @SerializedName("sunset")
    @Expose
    private val sunset: Int
)
package com.vendetta.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(

    @SerializedName("id")
    @Expose
    private val id: Int,
    @SerializedName("main")
    @Expose
    private val main: String,
    @SerializedName("description")
    @Expose
    private val description: String,
    @SerializedName("icon")
    @Expose
    private val icon: String

)
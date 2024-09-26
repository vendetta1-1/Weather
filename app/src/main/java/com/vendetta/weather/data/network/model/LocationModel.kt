package com.vendetta.weather.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LocationModel(

    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("region")
    @Expose
    val region: String,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("lon")
    @Expose
    val lon: Double,
    @SerializedName("tz_id")
    @Expose
    val tzId: String,
    @SerializedName("localtime_epoch")
    @Expose
    val localtimeEpoch: Int,
    @SerializedName("localtime")
    @Expose
    val localtime: String

)
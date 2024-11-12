package com.vendetta.weather.data.network.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CurrentDto(

    @SerializedName("last_updated_epoch")
    @Expose
    val lastUpdatedEpoch: Int,
    @SerializedName("last_updated")
    @Expose
    val lastUpdated: String,
    @SerializedName("temp_c")
    @Expose
    val tempC: Double,
    @SerializedName("condition")
    @Expose
    val condition: ConditionDto,
    @SerializedName("wind_kph")
    @Expose
    val windKph: Double,
    @SerializedName("wind_degree")
    @Expose
    val windDegree: Double,
    @SerializedName("wind_dir")
    @Expose
    val windDir: String,
    @SerializedName("pressure_mb")
    @Expose
    val pressureMb: Double,
    @SerializedName("pressure_in")
    @Expose
    val pressureIn: Double,
    @SerializedName("humidity")
    @Expose
    val humidity: Int,
    @SerializedName("cloud")
    @Expose
    val cloud: Int,
    @SerializedName("feelslike_c")
    @Expose
    val feelslikeC: Double,
    @SerializedName("vis_km")
    @Expose
    val visKm: Int,
    @SerializedName("uv")
    @Expose
    val uv: Double

)
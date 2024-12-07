package com.vendetta.weather.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentEntity(
    val lastUpdatedEpoch: Int,
    val lastUpdated: String,
    val tempC: Double,
    val condition: ConditionEntity,
    val windKph: Double,
    val windDegree: Double,
    val windDir: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeC: Double,
    val visKm: Int,
    val uv: Double

) : Parcelable
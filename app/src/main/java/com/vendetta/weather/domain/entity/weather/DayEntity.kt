package com.vendetta.weather.domain.entity.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DayEntity(
    val maxTempC: Double,
    val minTempC: Double,
    val dailyWillItRain: Int,
    val dailyChanceOfRain: Int,
    val condition: ConditionEntity,
    val uv: Double

) : Parcelable
package com.vendetta.weather.domain.entity.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastEntity(
    val forecastDay: List<ForecastDayEntity>
) : Parcelable
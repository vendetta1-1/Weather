package com.vendetta.weather.domain.entity.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastDayEntity(
    val date: String,
    val dateEpoch: Int,
    val dayEntity: DayEntity,
    val astro: AstroEntity,
) : Parcelable
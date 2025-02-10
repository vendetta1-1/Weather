package com.vendetta.weather.domain.entity.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AstroEntity(
    val sunrise: String,
    val sunset: String
) : Parcelable
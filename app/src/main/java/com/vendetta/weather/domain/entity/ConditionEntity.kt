package com.vendetta.weather.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConditionEntity(
    val text: String,
    val code: Int = 0
) : Parcelable
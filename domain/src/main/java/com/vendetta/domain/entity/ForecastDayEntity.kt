package com.vendetta.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class ForecastDayEntity(
    val date: String,
    val dateEpoch: Int,
    val dayEntity: DayEntity,
    val astro: AstroEntity,
)
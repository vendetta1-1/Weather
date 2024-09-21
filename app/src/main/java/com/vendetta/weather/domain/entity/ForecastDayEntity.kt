package com.vendetta.weather.domain.entity



data class ForecastDayEntity(
    val date: String,
    val dateEpoch: Int,
    val dayEntity: DayEntity,
    val astro: AstroEntity,
    val hour: List<HourEntity>
)
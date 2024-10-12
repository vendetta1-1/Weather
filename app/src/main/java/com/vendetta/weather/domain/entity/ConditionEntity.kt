package com.vendetta.weather.domain.entity

data class ConditionEntity(
    val text: String,
    val code: Int? = null
)
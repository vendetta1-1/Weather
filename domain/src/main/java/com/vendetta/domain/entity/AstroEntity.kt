package com.vendetta.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class AstroEntity(
    val sunrise: String,
    val sunset: String
)
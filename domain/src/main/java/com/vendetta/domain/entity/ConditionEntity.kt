package com.vendetta.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class ConditionEntity(
    val text: String,
    val code: Int = 0
)
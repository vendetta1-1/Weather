package com.vendetta.weather.domain.useCase

import android.location.Location
import com.google.gson.JsonObject
import com.vendetta.weather.domain.repository.WeatherRepository

class GetWeatherInCurrentLocationTomorrow(
    private val repository: WeatherRepository
) {

    suspend fun invoke(location: Location): JsonObject {
        return repository.getWeatherInCurrentLocationTomorrow(location)
    }
}
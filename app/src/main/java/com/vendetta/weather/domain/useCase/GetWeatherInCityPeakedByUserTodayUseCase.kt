package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository

class GetWeatherInCityPeakedByUserTodayUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(location: Location): WeatherEntity {
        return repository.getWeatherInCityPeakedByUserToday(location)
    }

}
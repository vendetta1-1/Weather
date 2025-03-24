package com.vendetta.domain.useCase

import com.vendetta.domain.entity.WeatherEntity
import com.vendetta.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(city: String): WeatherEntity {
        return repository.getWeatherInCityPeakedByUserDayAfterTomorrow(city)
    }
}
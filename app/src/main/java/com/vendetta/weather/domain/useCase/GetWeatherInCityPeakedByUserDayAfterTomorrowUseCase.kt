package com.vendetta.weather.domain.useCase

import android.location.Location
import com.vendetta.weather.domain.repository.WeatherRepository

class GetWeatherInCityPeakedByUserDayAfterTomorrowUseCase(
    private val repository: WeatherRepository
) {

   suspend fun invoke(location: Location) {
        return repository.getWeatherInCityPeakedByUserDayAfterTomorrow(location)
    }

}
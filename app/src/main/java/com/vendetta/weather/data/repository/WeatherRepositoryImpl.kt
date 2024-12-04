package com.vendetta.weather.data.repository

import android.location.Location
import com.vendetta.weather.data.mapper.toEntity
import com.vendetta.weather.data.network.ApiService
import com.vendetta.weather.domain.entity.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity {
        return apiService.loadWeatherToday(
            formatLocation(location)
        ).toEntity()
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity {
        return apiService.loadWeatherTomorrow(
            formatLocation(location)
        ).toEntity()

    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity {
        return apiService.loadWeatherDayAfterTomorrow(
            formatLocation(location)
        ).toEntity()

    }

    override suspend fun getWeatherInCityPeakedByUserToday(city: String): WeatherEntity {
        return apiService.loadWeatherToday(city).toEntity()

    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(city: String): WeatherEntity {
        return apiService.loadWeatherTomorrow(city).toEntity()

    }

    override suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(city: String): WeatherEntity {
        return apiService.loadWeatherDayAfterTomorrow(city).toEntity()

    }
    
    private fun formatLocation(location: Location): String {
        return "${location.latitude},${location.longitude}"
    }

}
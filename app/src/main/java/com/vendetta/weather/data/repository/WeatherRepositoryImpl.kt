package com.vendetta.weather.data.repository

import android.location.Location
import com.vendetta.weather.data.mapper.toEntity
import com.vendetta.weather.data.network.api.ApiService
import com.vendetta.weather.domain.entity.weather.WeatherEntity
import com.vendetta.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    override suspend fun getWeatherInCurrentLocationToday(location: Location): WeatherEntity {
        return scope.async {
            apiService.loadWeatherToday(formatLocation(location)).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location): WeatherEntity {
        return scope.async {
            apiService.loadWeatherTomorrow(formatLocation(location)).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location): WeatherEntity {
        return scope.async {
            apiService.loadWeatherDayAfterTomorrow(formatLocation(location)).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCityPeakedByUserToday(city: String): WeatherEntity {
        return scope.async {
            apiService.loadWeatherToday(city).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(city: String): WeatherEntity {
        return scope.async {
            apiService.loadWeatherTomorrow(city).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(city: String): WeatherEntity {
        return scope.async {
            apiService.loadWeatherDayAfterTomorrow(city).toEntity()
        }.await()
    }

    private fun formatLocation(location: Location): String {
        return "${location.latitude},${location.longitude}"
    }
}
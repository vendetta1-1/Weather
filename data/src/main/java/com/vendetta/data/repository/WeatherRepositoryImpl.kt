package com.vendetta.data.repository

import com.vendetta.data.mapper.toEntity
import com.vendetta.data.network.api.ApiService
import com.vendetta.domain.entity.WeatherEntity
import com.vendetta.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    private val scope = CoroutineScope(Dispatchers.IO)

    override suspend fun getWeatherInCurrentLocationToday(
        latitude: Double,
        longitude: Double
    ): WeatherEntity {
        return scope.async {
            apiService.loadWeatherToday(formatLocation(latitude, longitude)).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(
        latitude: Double,
        longitude: Double
    ): WeatherEntity {
        return scope.async {
            apiService.loadWeatherTomorrow(formatLocation(latitude, longitude)).toEntity()
        }.await()
    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(
        latitude: Double,
        longitude: Double
    ): WeatherEntity {
        return scope.async {
            apiService.loadWeatherDayAfterTomorrow(formatLocation(latitude, longitude)).toEntity()
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

    private fun formatLocation(latitude: Double, longitude: Double): String = "$latitude,$longitude"
}
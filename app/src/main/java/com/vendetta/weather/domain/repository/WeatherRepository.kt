package com.vendetta.weather.domain.repository

import android.location.Location
import com.google.gson.JsonObject

interface WeatherRepository {

    suspend fun getWeatherInCurrentLocationToday(location: Location)

    suspend fun getWeatherInCurrentLocationTomorrow(location: Location): JsonObject

    suspend fun getWeatherInCurrentLocationForFiveDays(location: Location): JsonObject

    suspend fun getWeatherInCityPeakedByUserToday(location: Location): JsonObject

    suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location): JsonObject

    suspend fun getWeatherInCityPeakedByUserForFiveDays(location: Location): JsonObject

}
package com.vendetta.weather.data

import android.location.Location
import android.util.Log
import com.google.gson.JsonObject
import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.domain.repository.WeatherRepository


class WeatherRepositoryImpl : WeatherRepository {


    private val apiService = ApiFactory.apiService

    companion object {
        private const val API_KEY = "9e259fdb9b1d998ab743f84f80a00504"

    }

    override suspend fun getWeatherInCurrentLocationToday(location: Location) {
        Log.i("Weather-Response",(apiService.loadWeather(location.latitude, location.longitude, API_KEY).toString()))
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location): JsonObject {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCurrentLocationForFiveDays(location: Location): JsonObject {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCityPeakedByUserToday(location: Location): JsonObject {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location): JsonObject {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCityPeakedByUserForFiveDays(location: Location): JsonObject {
        TODO("Not yet implemented")
    }

}
package com.vendetta.weather.data

import android.location.Location
import android.util.Log
import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.domain.repository.WeatherRepository


class WeatherRepositoryImpl : WeatherRepository {


    private val apiService = ApiFactory.apiService

    companion object {
        private const val TAG = "Weather-Response"
        private const val API_KEY = "215d4f335ca94d4c8d2125219241703"

    }

    override suspend fun getWeatherInCurrentLocationToday(location: Location) {
        Log.i(
            TAG,
            (apiService.loadWeatherToday(
                "${location.latitude},${location.longitude}",
                API_KEY
            ).toString())
        )
    }

    override suspend fun getWeatherInCurrentLocationTomorrow(location: Location) {
        Log.i(
            TAG,
            (apiService.loadWeatherTomorrow(
                "${location.latitude},${location.longitude}",
                API_KEY
            ).toString())
        )
    }

    override suspend fun getWeatherInCurrentLocationDayAfterTomorrow(location: Location) {
        Log.i(
            TAG,
            apiService.loadWeatherDayAfterTomorrow(
                "${location.latitude},${location.longitude}",
                API_KEY
            ).toString()
        )
    }

    override suspend fun getWeatherInCityPeakedByUserToday(location: Location) {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCityPeakedByUserTomorrow(location: Location) {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherInCityPeakedByUserDayAfterTomorrow(location: Location) {
        TODO("Not yet implemented")
    }

}
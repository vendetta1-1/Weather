package com.vendetta.weather.data.network

import com.vendetta.weather.data.network.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface ApiService {

    companion object {
        const val API_KEY = "215d4f335ca94d4c8d2125219241703"
    }

    @GET("forecast.json")
    suspend fun loadWeatherToday(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String = API_KEY
    ): WeatherModel

    @GET("forecast.json")
    suspend fun loadWeatherTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String = API_KEY,
        @Query("dt") day: String = LocalDate.now().plusDays(1).toString()
    ): WeatherModel

    @GET("forecast.json")
    suspend fun loadWeatherDayAfterTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String = API_KEY,
        @Query("dt") day: String = LocalDate.now().plusDays(2).toString()
    ): WeatherModel
}
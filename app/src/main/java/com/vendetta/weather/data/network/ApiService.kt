package com.vendetta.weather.data.network

import com.vendetta.weather.data.model.WeatherResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface ApiService {

    @GET("forecast.json")
    suspend fun loadWeatherToday(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
    ): WeatherResponseModel

    @GET("forecast.json")
    suspend fun loadWeatherTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
        @Query("dt") day: String = LocalDate.now().plusDays(1).toString()
    ): WeatherResponseModel

    @GET("forecast.json")
    suspend fun loadWeatherDayAfterTomorrow(
        @Query("q") coordinates: String, //format : Latitude,Longitude
        @Query("key") apiKey: String,
        @Query("dt") day: String = LocalDate.now().plusDays(2).toString()
    ): WeatherResponseModel
}
package com.vendetta.weather.data.network

import androidx.compose.ui.text.intl.Locale
import com.vendetta.weather.data.model.WeatherResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather")
    suspend fun loadWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("lang") language: String = Locale.current.language
    ): WeatherResponseModel
}
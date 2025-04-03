package com.vendetta.navigation

import android.net.Uri
import com.google.gson.Gson
import com.vendetta.domain.entity.WeatherEntity
import com.vendetta.domain.useCase.GetWeatherInCurrentLocationDayAfterTomorrowUseCase

sealed class Screen(
    val route: String
) {
    data object Loading : Screen(route = LOADING_ROUTE)

    data object Search : Screen(route = SEARCH_ROUTE)

    data object Weather : Screen(route = WEATHER_ROUTE) {

        private const val ROUTE_FOR_ARGS = "weather"

        fun getRouteWithArgs(
            todayWeather: WeatherEntity,
            tomorrowWeather: WeatherEntity,
            dayAfterTomorrowWeather: WeatherEntity,
            isCurrentLocation: Boolean
        ): String {
            val gson = Gson()
            val todayWeatherJson = gson.toJson(todayWeather)
            val tomorrowWeatherJson = gson.toJson(tomorrowWeather)
            val dayAfterTomorrowWeatherJson = gson.toJson(dayAfterTomorrowWeather)
            return "$ROUTE_FOR_ARGS/${todayWeatherJson.encode()}/${tomorrowWeatherJson.encode()}/${dayAfterTomorrowWeatherJson.encode()}/$isCurrentLocation"
        }
    }

    companion object {
        const val TODAY_WEATHER_KEY = "today_weather"
        const val TOMORROW_WEATHER_KEY = "tomorrow_weather"
        const val DAY_AFTER_TOMORROW_WEATHER_KEY = "day_after_tomorrow_weather"
        const val IS_CURRENT_LOCATION_KEY = "is_current_location"
        private const val WEATHER_ROUTE =
            "weather/{$TODAY_WEATHER_KEY}/{${TOMORROW_WEATHER_KEY}}/{${DAY_AFTER_TOMORROW_WEATHER_KEY}}/{$IS_CURRENT_LOCATION_KEY}"
        private const val LOADING_ROUTE = "loading"
        private const val SEARCH_ROUTE = "search"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}
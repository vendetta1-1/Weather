package com.vendetta.weather.navigation

import android.net.Uri
import com.google.gson.Gson
import com.vendetta.weather.domain.entity.weather.WeatherEntity

sealed class Screen(
    val route: String
) {
    data object Loading : Screen(route = LOADING_ROUTE)

    data object Search : Screen(route = SEARCH_ROUTE)

    data object Weather : Screen(route = WEATHER_ROUTE) {

        private const val ROUTE_FOR_ARGS = "weather"

        fun getRouteWithArgs(weatherEntity: WeatherEntity, isCurrentLocation: Boolean): String {
            val weatherEntityJson = Gson().toJson(weatherEntity)
            return "$ROUTE_FOR_ARGS/${weatherEntityJson.encode()}/$isCurrentLocation"
        }
    }

    companion object {
        const val WEATHER_KEY = "weather_entity"
        const val IS_CURRENT_LOCATION_KEY = "is_current_location"
        private const val WEATHER_ROUTE = "weather/{$WEATHER_KEY}/{$IS_CURRENT_LOCATION_KEY}"
        private const val LOADING_ROUTE = "loading"
        private const val SEARCH_ROUTE = "search"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}
package com.vendetta.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.vendetta.domain.entity.WeatherEntity

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    loadingScreenContent: @Composable () -> Unit,
    searchScreenContent: @Composable () -> Unit,
    weatherScreenContent: @Composable (WeatherEntity, WeatherEntity, WeatherEntity, Boolean) -> Unit,
) {
    NavHost(
        navController = navHostController, startDestination = Screen.Loading.route
    ) {
        composable(Screen.Loading.route) {
            loadingScreenContent()
        }

        composable(
            route = Screen.Weather.route,
            arguments = listOf(
                navArgument(
                    name = Screen.TODAY_WEATHER_KEY
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = Screen.TOMORROW_WEATHER_KEY
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = Screen.DAY_AFTER_TOMORROW_WEATHER_KEY
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = Screen.IS_CURRENT_LOCATION_KEY
                ) {
                    type = NavType.BoolType
                }
            )
        ) { entry ->
            val gson = Gson()
            val todayWeatherJson = entry.arguments?.getString(Screen.TODAY_WEATHER_KEY) ?: throw RuntimeException("object todayWeatherEntity was not transfer")
            val tomorrowWeatherJson = entry.arguments?.getString(Screen.TOMORROW_WEATHER_KEY) ?: throw RuntimeException("object tomorrowWeatherEntity was not transfer")
            val dayAfterTomorrowWeatherJson = entry.arguments?.getString(Screen.DAY_AFTER_TOMORROW_WEATHER_KEY) ?: throw RuntimeException("object dayAfterTomorrowWeatherEntity was not transfer")
            val isCurrentLocation = entry.arguments?.getBoolean(Screen.IS_CURRENT_LOCATION_KEY) ?: false

            val todayWeather = gson.fromJson(todayWeatherJson, WeatherEntity::class.java)
            val tomorrowWeather = gson.fromJson(tomorrowWeatherJson, WeatherEntity::class.java)
            val dayAfterTomorrowWeather = gson.fromJson(dayAfterTomorrowWeatherJson, WeatherEntity::class.java)

            weatherScreenContent(todayWeather,tomorrowWeather,dayAfterTomorrowWeather,isCurrentLocation)
        }

        composable(Screen.Search.route) {
            searchScreenContent()
        }
    }
}

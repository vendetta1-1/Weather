package com.vendetta.weather.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.vendetta.weather.domain.entity.weather.WeatherEntity

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    loadingScreenContent: @Composable () -> Unit,
    searchScreenContent: @Composable () -> Unit,
    weatherScreenContent: @Composable (WeatherEntity, Boolean) -> Unit,
) {
    NavHost(
        navController = navHostController, startDestination = Screen.Loading.route
    ) {
        composable(Screen.Loading.route) {
            loadingScreenContent()
        }

        composable(
            route = Screen.Weather.route, arguments = listOf(
                navArgument(
                    name = Screen.WEATHER_KEY
                ) {
                    type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        WeatherEntity.NavigationType
                    } else {
                        NavType.StringType
                    }
                }, navArgument(
                    name = Screen.IS_CURRENT_LOCATION_KEY
                ) {
                    type = NavType.BoolType
                }
            )
        ) { entry ->
            val weather: WeatherEntity =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    entry.arguments?.getParcelable(Screen.WEATHER_KEY, WeatherEntity::class.java)
                } else {
                    val weatherEntityJson = entry.arguments?.getString(Screen.WEATHER_KEY)
                    Gson().fromJson(weatherEntityJson, WeatherEntity::class.java)
                }
                    ?: throw RuntimeException("object WeatherEntity was not transferred. weather == null")
            val isCurrentLocation = entry.arguments?.getBoolean(Screen.IS_CURRENT_LOCATION_KEY)
                ?: throw RuntimeException("isCurrent location == null")
            weatherScreenContent(weather, isCurrentLocation)
        }

        composable(Screen.Search.route) {
            searchScreenContent()
        }
    }
}

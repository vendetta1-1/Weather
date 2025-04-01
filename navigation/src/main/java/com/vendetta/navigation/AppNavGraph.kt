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
                    type = NavType.StringType
                }, navArgument(
                    name = Screen.IS_CURRENT_LOCATION_KEY
                ) {
                    type = NavType.BoolType
                }
            )
        ) { entry ->
            val weatherEntityJson = entry.arguments?.getString(Screen.WEATHER_KEY)
            val weather: WeatherEntity =
                Gson().fromJson(weatherEntityJson, WeatherEntity::class.java)
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

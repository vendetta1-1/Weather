package com.vendetta.weather.navigation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.vendetta.weather.domain.entity.WeatherEntity

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    loadingScreenContent: @Composable () -> Unit,
    searchScreenContent: @Composable () -> Unit,
    weatherScreenContent: @Composable (WeatherEntity) -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Loading.route
    ) {
        composable(Screen.Loading.route) {
            loadingScreenContent()
        }

        composable(
            route = Screen.Weather.route,
            arguments = listOf(
                navArgument(
                    name = Screen.WEATHER_KEY
                ) {
                    type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        WeatherEntity.NavigationType
                    } else {
                        NavType.StringType
                    }
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
            weatherScreenContent(weather)
        }

        composable(Screen.Search.route) {
            searchScreenContent()
        }
    }
}

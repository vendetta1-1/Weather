package com.vendetta.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vendetta.domain.entity.WeatherEntity

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(route: String) {
        navHostController.navigate(route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }


    fun navigateToWeather(
        todayWeather: WeatherEntity,
        tomorrowWeather: WeatherEntity,
        dayAfterTomorrowWeather: WeatherEntity,
        isCurrentLocation: Boolean
    ) {
        navHostController.popBackStack()
        navHostController.navigate(
            Screen.Weather.getRouteWithArgs(
                todayWeather,
                tomorrowWeather,
                dayAfterTomorrowWeather,
                isCurrentLocation
            )
        )
    }

}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}
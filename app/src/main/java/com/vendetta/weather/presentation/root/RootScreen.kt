package com.vendetta.weather.presentation.root

import androidx.compose.runtime.Composable
import com.google.android.gms.location.FusedLocationProviderClient
import com.vendetta.navigation.AppNavGraph
import com.vendetta.navigation.Screen
import com.vendetta.navigation.rememberNavigationState
import com.vendetta.weather.presentation.factory.ViewModelFactory
import com.vendetta.weather.presentation.loading.LoadingScreen
import com.vendetta.weather.presentation.search.SearchScreen
import com.vendetta.weather.presentation.weather.WeatherScreen

@Composable
fun RootScreen(
    viewModelFactory: ViewModelFactory,
    locationClient: FusedLocationProviderClient
) {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        loadingScreenContent = {
            LoadingScreen(
                navToWeather = navigationState::navigateToWeather,
                viewModelFactory = viewModelFactory,
                locationClient = locationClient
            )
        },
        searchScreenContent = {
            SearchScreen(
                viewModelFactory = viewModelFactory,
                onBackButtonBackListener = {
                    navigationState.navHostController.popBackStack()
                },
                navToWeather = navigationState::navigateToWeather
            )
        },
        weatherScreenContent = { todayWeather, tomorrowWeather, dayAfterTomorrowWeather, isCurrentLocation ->
            WeatherScreen(
                todayWeatherEntity = todayWeather,
                tomorrowWeatherEntity = tomorrowWeather,
                dayAfterTomorrowWeather = dayAfterTomorrowWeather,
                isCurrentLocation = isCurrentLocation,
                onSearchButtonClickListener = { navigationState.navigateTo(Screen.Search.route) },
                onBackButtonClickListener = { navigationState.navHostController.popBackStack() }
            )
        }
    )
}




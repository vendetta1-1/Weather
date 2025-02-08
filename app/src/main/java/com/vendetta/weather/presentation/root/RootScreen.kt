package com.vendetta.weather.presentation.root

import android.app.Activity
import androidx.compose.runtime.Composable
import com.vendetta.weather.navigation.AppNavGraph
import com.vendetta.weather.navigation.Screen
import com.vendetta.weather.navigation.rememberNavigationState
import com.vendetta.weather.presentation.factory.ViewModelFactory
import com.vendetta.weather.presentation.loading.LoadingScreen
import com.vendetta.weather.presentation.search.SearchScreen
import com.vendetta.weather.presentation.weather.WeatherScreen

@Composable
fun RootScreen(
    activity: Activity,
    viewModelFactory: ViewModelFactory
) {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        loadingScreenContent = {
            LoadingScreen(
                navToWeather = navigationState::navigateToWeather,
                viewModelFactory = viewModelFactory,
                activity = activity
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
        weatherScreenContent = { weatherEntity, isCurrentLocation ->
            WeatherScreen(
                weatherEntity = weatherEntity,
                isCurrentLocation = isCurrentLocation,
                onSearchButtonClickListener = { navigationState.navigateTo(Screen.Search.route) },
                onBackButtonClickListener = { navigationState.navHostController.popBackStack() }
            )
        }
    )


}




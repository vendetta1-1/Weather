package com.vendetta.weather.presentation.views.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.navigation.AppNavGraph
import com.vendetta.weather.navigation.Screen
import com.vendetta.weather.navigation.rememberNavigationState
import com.vendetta.weather.presentation.views.loading.LoadingScreen
import com.vendetta.weather.presentation.views.loading.LoadingScreenState
import com.vendetta.weather.presentation.views.loading.LoadingViewModel
import com.vendetta.weather.presentation.views.search.SearchScreen
import com.vendetta.weather.presentation.views.weather.WeatherScreen

@Composable
fun RootScreen(
    viewModel: LoadingViewModel = viewModel(),
    onStartLoadingScreen: () -> Unit
) {
    val navigationState = rememberNavigationState()
    val loadingScreenState = viewModel.screenState.observeAsState(LoadingScreenState.Initial)
    AppNavGraph(
        navHostController = navigationState.navHostController,
        loadingScreenContent = {
            val currentState = loadingScreenState.value
            LoadingScreen(
                onStartScreen = {
                    if (currentState is LoadingScreenState.Success) {
                        navigationState.navigateToWeather(currentState.currentWeatherEntity)
                    } else {
                        onStartLoadingScreen()
                    }
                }
            )
        },
        searchScreenContent = {
            SearchScreen(
                onButtonClickListener = {

                },
                onBackButtonBackListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        },
        weatherScreenContent = {
            WeatherScreen(
                weatherEntity = it,
                onSearchButtonClickListener = { navigationState.navigateTo(Screen.Search.route) }
            )
        }
    )


}




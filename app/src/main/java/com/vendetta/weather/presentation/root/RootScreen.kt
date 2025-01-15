package com.vendetta.weather.presentation.root

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vendetta.weather.navigation.AppNavGraph
import com.vendetta.weather.navigation.Screen
import com.vendetta.weather.navigation.rememberNavigationState
import com.vendetta.weather.presentation.factory.ViewModelFactory
import com.vendetta.weather.presentation.loading.LoadingScreen
import com.vendetta.weather.presentation.loading.LoadingScreenState
import com.vendetta.weather.presentation.loading.LoadingViewModel
import com.vendetta.weather.presentation.search.SearchScreen
import com.vendetta.weather.presentation.search.SearchScreenState
import com.vendetta.weather.presentation.search.SearchViewModel
import com.vendetta.weather.presentation.weather.WeatherScreen

@Composable
fun RootScreen(
    activity: Activity,
    viewModelFactory: ViewModelFactory,
) {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        loadingScreenContent = {
            val loadingViewModel: LoadingViewModel = viewModel(factory = viewModelFactory)
            val loadingState =
                loadingViewModel.screenState.observeAsState(LoadingScreenState.Initial)
            val currentState = loadingState.value
            LoadingScreen(
                onStartScreen = {
                    loadingViewModel.getWeather(activity)
                    if (currentState is LoadingScreenState.Success) {
                        navigationState.navigateToWeather(
                            currentState.currentWeatherEntity,
                            isCurrentLocation = true
                        )
                    }
                }
            )
        },
        searchScreenContent = {
            val searchViewModel: SearchViewModel = viewModel(factory = viewModelFactory)
            val searchState = searchViewModel.screenState.observeAsState(SearchScreenState.Initial)
            val currentState = searchState.value
            SearchScreen(
                onButtonClickListener = { city ->
                    searchViewModel.loadWeather(city)
                    if (currentState is SearchScreenState.Loading) {
                        navigationState.navigateToWeather(
                            currentState.currentWeatherEntity,
                            isCurrentLocation = false
                        )
                    }
                },
                onBackButtonBackListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        },
        weatherScreenContent = { weatherEntity, isCurrentLocation ->
            WeatherScreen(
                weatherEntity = weatherEntity,
                isCurrentLocation = isCurrentLocation,
                onSearchButtonClickListener = { navigationState.navigateTo(Screen.Search.route) }
            )
        }
    )


}




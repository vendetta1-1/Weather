package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vendetta.weather.getApplicationComponent
import com.vendetta.weather.presentation.root.RootScreen
import com.vendetta.weather.presentation.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val component = getApplicationComponent()
            val viewModelFactory = component.getViewModelFactory()
            val locationClient = component.getLocationClient()
            WeatherTheme {
                RootScreen(
                    viewModelFactory = viewModelFactory,
                    locationClient = locationClient
                )
            }
        }
    }
}



package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.vendetta.weather.ui.content.WeatherScreen
import com.vendetta.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {


    private val viewModel by viewModels<MainViewModel>()

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        viewModel.getWeather(this, fusedLocationProviderClient)

        setContent {
            WeatherTheme {
                WeatherTheme {
                    WeatherScreen(viewModel, true)
                }
            }
        }
    }
}



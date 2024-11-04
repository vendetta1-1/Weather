package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.vendetta.weather.WeatherApp
import com.vendetta.weather.ui.content.WeatherScreen
import com.vendetta.weather.ui.theme.WeatherTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (applicationContext as WeatherApp).applicationComponent
    }

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        viewModel.getWeather(this, fusedLocationProviderClient)

        setContent {
            WeatherTheme {
                WeatherTheme {
                    WeatherScreen(viewModel.currentWeatherEntity, true)
                }
            }
        }
    }
}



package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.vendetta.weather.WeatherApp
import com.vendetta.weather.ui.content.MainScreen
import com.vendetta.weather.ui.theme.WeatherTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as WeatherApp).applicationComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        viewModel.getWeather(this, fusedLocationProviderClient)

        setContent {
            WeatherTheme {
                MainScreen(viewModel)
            }
        }
    }
}



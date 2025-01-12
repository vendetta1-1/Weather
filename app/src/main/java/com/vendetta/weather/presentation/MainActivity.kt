package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.vendetta.weather.WeatherApp
import com.vendetta.weather.presentation.factory.ViewModelFactory
import com.vendetta.weather.presentation.views.loading.LoadingViewModel
import com.vendetta.weather.presentation.views.root.RootScreen
import com.vendetta.weather.ui.theme.WeatherTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as WeatherApp).applicationComponent
    }

    @Inject
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LoadingViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            WeatherTheme {
                RootScreen(
                    viewModel,
                    onStartLoadingScreen = {
                        viewModel.getWeather(this, fusedLocationProviderClient)
                    }
                )
            }
        }
    }
}



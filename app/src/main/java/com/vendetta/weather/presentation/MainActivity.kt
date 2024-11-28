package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
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

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        viewModel.getWeather(this)

        setContent {
            WeatherTheme {
                MainScreen(viewModel)
            }
        }
    }
}



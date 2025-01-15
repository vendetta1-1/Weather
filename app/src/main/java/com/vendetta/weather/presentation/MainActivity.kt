package com.vendetta.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vendetta.weather.WeatherApp
import com.vendetta.weather.presentation.factory.ViewModelFactory
import com.vendetta.weather.presentation.root.RootScreen
import com.vendetta.weather.ui.theme.WeatherTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as WeatherApp).applicationComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            WeatherTheme {
                RootScreen(
                    activity = this,
                    viewModelFactory
                )
            }
        }
    }
}



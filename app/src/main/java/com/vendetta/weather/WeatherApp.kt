package com.vendetta.weather

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.location.LocationServices
import com.vendetta.weather.di.ApplicationComponent
import com.vendetta.weather.di.DaggerApplicationComponent

class WeatherApp : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(
            this,
            LocationServices.getFusedLocationProviderClient(this)
        )
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as WeatherApp).applicationComponent
}
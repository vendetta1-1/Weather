package com.vendetta.weather

import android.app.Application
import com.google.android.gms.location.LocationServices
import com.vendetta.weather.di.ApplicationComponent
import com.vendetta.weather.di.DaggerApplicationComponent

class WeatherApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory()
            .create(this, LocationServices.getFusedLocationProviderClient(this))
    }
}
package com.vendetta.weather.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.vendetta.weather.presentation.factory.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    fun getLocationClient(): FusedLocationProviderClient

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application,
            @BindsInstance fusedLocationProviderClient: FusedLocationProviderClient
        ): ApplicationComponent

    }
}
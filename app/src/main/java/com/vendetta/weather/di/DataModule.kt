package com.vendetta.weather.di

import com.vendetta.data.network.api.ApiFactory
import com.vendetta.data.network.api.ApiService
import com.vendetta.data.repository.WeatherRepositoryImpl
import com.vendetta.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindWeatherRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.api
    }
}
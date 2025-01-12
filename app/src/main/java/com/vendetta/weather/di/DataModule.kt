package com.vendetta.weather.di

import com.vendetta.weather.data.network.api.ApiFactory
import com.vendetta.weather.data.network.api.ApiService
import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}
package com.vendetta.weather.di

import android.app.Application
import com.vendetta.weather.data.database.WeatherDao
import com.vendetta.weather.data.database.WeatherDataBase
import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.data.network.ApiService
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

        @ApplicationScope
        @Provides
        fun provideWeatherDao(
            application: Application
        ): WeatherDao {
            return WeatherDataBase.getInstance(application).weatherDao()
        }
    }
}
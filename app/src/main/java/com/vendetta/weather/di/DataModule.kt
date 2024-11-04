package com.vendetta.weather.di

import com.vendetta.weather.data.network.ApiFactory
import com.vendetta.weather.data.network.ApiService
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}
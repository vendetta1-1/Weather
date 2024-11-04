package com.vendetta.weather.di

import com.vendetta.weather.data.repository.WeatherRepositoryImpl
import com.vendetta.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository

}
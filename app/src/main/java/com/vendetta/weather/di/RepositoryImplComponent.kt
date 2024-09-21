package com.vendetta.weather.di

import com.vendetta.weather.data.WeatherRepositoryImpl
import dagger.Component

@Component
interface RepositoryImplComponent {


    fun getRepositoryImpl(): WeatherRepositoryImpl

}
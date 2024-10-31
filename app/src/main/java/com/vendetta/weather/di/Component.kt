package com.vendetta.weather.di

import com.vendetta.weather.presentation.MainViewModel
import dagger.Component

@Component(modules = [DataModule::class])
interface Component {

    fun injectMainViewModel(): MainViewModel
}
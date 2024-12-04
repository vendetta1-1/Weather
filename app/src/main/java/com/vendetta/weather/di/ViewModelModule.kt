package com.vendetta.weather.di

import androidx.lifecycle.ViewModel
import com.vendetta.weather.presentation.MainViewModel
import com.vendetta.weather.presentation.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    @Binds
    fun bindSearchViewModel(impl: SearchViewModel): ViewModel
}
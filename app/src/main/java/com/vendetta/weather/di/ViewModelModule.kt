package com.vendetta.weather.di

import androidx.lifecycle.ViewModel
import com.vendetta.weather.presentation.loading.LoadingViewModel
import com.vendetta.weather.presentation.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(LoadingViewModel::class)
    @Binds
    fun bindLoadingViewModel(impl: LoadingViewModel): ViewModel

    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    @Binds
    fun bindSearchViewModel(impl: SearchViewModel): ViewModel
}
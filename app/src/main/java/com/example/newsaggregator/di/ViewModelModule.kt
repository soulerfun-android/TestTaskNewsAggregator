package com.example.newsaggregator.di

import androidx.lifecycle.ViewModel
import com.example.newsaggregator.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @ViewModelKey(MainViewModel::class)
    @Binds
    @IntoMap
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
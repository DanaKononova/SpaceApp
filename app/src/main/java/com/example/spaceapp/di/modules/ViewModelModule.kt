package com.example.spaceapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.spaceapp.di.ViewModelKey
import com.example.spaceapp.ui.start.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    fun bindStartViewModel(viewModel: StartViewModel): ViewModel
}
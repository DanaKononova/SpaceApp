package com.example.spaceapp.di

import android.content.Context
import com.example.spaceapp.di.modules.NetworkModule
import com.example.spaceapp.di.modules.RepositoryModule
import com.example.spaceapp.di.modules.SourceModule
import com.example.spaceapp.di.modules.ViewModelModule
import com.example.spaceapp.ui.start.StartFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, SourceModule::class, ViewModelModule::class, RepositoryModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: StartFragment)
}
package com.example.spaceapp.di.modules

import com.example.spaceapp.data.RepositoryImpl
import com.example.spaceapp.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun getRepository(impl: RepositoryImpl): Repository
}
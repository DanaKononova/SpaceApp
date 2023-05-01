package com.example.spaceapp

import android.app.Application
import com.example.spaceapp.di.AppComponent
import com.example.spaceapp.di.DaggerAppComponent

class SpaceApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
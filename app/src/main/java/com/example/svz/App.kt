package com.example.svz

import android.app.Application
import com.example.svz.di.AppComponent
import com.example.svz.di.AppModule
import com.example.svz.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}
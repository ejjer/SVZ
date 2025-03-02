package com.example.svz.di

import com.example.svz.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun getViewModelFactory(): DaggerViewModelFactory
}
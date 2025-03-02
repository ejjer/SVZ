package com.example.svz.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.svz.presentation.viewModels.RegisterViewModel
import com.example.svz.presentation.viewModels.RecipeListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListViewModel::class)
    abstract fun bindRecipeListViewModel(viewModel: RecipeListViewModel): ViewModel

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}
package com.example.svz.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.svz.di.DaggerViewModelFactory
import com.example.svz.domain.useCase.RegisterUserUseCase
import com.example.svz.presentation.ui.screens.StartScreen
import com.example.svz.presentation.ui.screens.LoginScreen
import com.example.svz.presentation.ui.screens.RegistrationScreen
import javax.inject.Provider

@Composable
fun NavGraph(
    navController: NavHostController,
    registerUserUseCase: RegisterUserUseCase
) {
    val viewModelFactory = DaggerViewModelFactory(mapOf(
        RegisterViewModel::class.java to Provider { RegisterViewModel(registerUserUseCase) }
    ))

    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            StartScreen(navController)
        }
        composable("login") {
            LoginScreen()
        }
        composable("registration") {
            RegistrationScreen(viewModel = viewModel(factory = viewModelFactory))
        }
    }
}
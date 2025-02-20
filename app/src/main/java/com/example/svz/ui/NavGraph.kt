package com.example.svz.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.svz.ui.screens.StartScreen
import com.example.svz.ui.screens.LoginScreen
import com.example.svz.ui.screens.RegistrationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            StartScreen(navController)
        }
        composable("login") {
            LoginScreen()
        }
        composable("registration") {
            RegistrationScreen()
        }
    }
}

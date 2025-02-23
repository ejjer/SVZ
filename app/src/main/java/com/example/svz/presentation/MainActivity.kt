package com.example.svz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.svz.App
import com.example.svz.domain.useCase.LoginUseCase
import com.example.svz.domain.useCase.RegisterUserUseCase
import com.example.svz.presentation.ui.NavGraph
import com.example.svz.presentation.ui.theme.SVZTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var registerUserUseCase: RegisterUserUseCase

    @Inject
    lateinit var loginUseCase: LoginUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            SVZTheme {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    registerUserUseCase = registerUserUseCase,
                    loginUseCase = loginUseCase
                )
            }
        }
    }
}
package com.example.svz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.svz.ui.LoginScreen
import com.example.svz.ui.RegistrationScreen
import com.example.svz.ui.StartScreen
import com.example.svz.ui.theme.SVZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SVZTheme {
                StartScreen()
            }
        }
    }
}
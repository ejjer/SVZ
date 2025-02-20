package com.example.svz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController // Используем правильный тип
import com.example.svz.ui.NavGraph
import com.example.svz.ui.theme.SVZTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Создаем NavHostController
            val navController = rememberNavController()

            // Передаем navController в NavGraph
            NavGraph(navController = navController)
        }
    }
}

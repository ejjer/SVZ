package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svz.presentation.ui.theme.SVZTheme

@Preview
@Composable
fun BottomBar() {
    SVZTheme {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.primary // Цвет фона BottomBar
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Notifications, contentDescription = "Уведомления") },
                selected = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary, // Цвет выбранной иконки
                    unselectedIconColor = Color.White // Белый цвет для невыбранных иконок
                ),
                onClick = { /* Обработка нажатия */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Favorite, contentDescription = "Избранное") },
                selected = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.White // Белый цвет для невыбранных иконок
                ),
                onClick = { /* Обработка нажатия */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Add, contentDescription = "Добавить") },
                selected = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.White // Белый цвет для невыбранных иконок
                ),
                onClick = { /* Обработка нажатия */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Профиль") },
                selected = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.White // Белый цвет для невыбранных иконок
                ),
                onClick = { /* Обработка нажатия */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Дом") },
                selected = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = Color.White // Белый цвет для невыбранных иконок
                ),
                onClick = { /* Обработка нажатия */ }
            )
        }
    }
}
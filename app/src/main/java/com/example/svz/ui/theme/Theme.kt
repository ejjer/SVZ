package com.example.svz.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Цвета для кнопок
private val ButtonColor = Color(0xFF45624E)  // Цвет кнопок #45624E

// Цветовая схема для светлой темы
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF45624E),       // Основной цвет будет цветом кнопок
    onPrimary = Color.White,     // Цвет текста на кнопках
    secondary = ButtonColor,    // Вы можете установить тот же цвет для вторичных элементов, если нужно
    onSecondary = Color.White,  // Текст на вторичных элементах
    background = Color(0xFFFFFFFF), // Цвет фона
    onBackground = Color.Black,    // Цвет текста на фоне
)

@Composable
fun SVZTheme(
    // Отключаем использование флага darkTheme, всегда будем использовать светлую тему
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        // Используем динамическую палитру для светлой темы
        val context = LocalContext.current
        dynamicLightColorScheme(context)
    } else {
        // Явно задаем светлую цветовую палитру
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
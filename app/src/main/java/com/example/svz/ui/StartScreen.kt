package com.example.svz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svz.R
import com.example.svz.ui.theme.SVZTheme

@Preview
@Composable
fun StartScreen() {
    SVZTheme  {  // Применяем вашу тему
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(
                        top = 64.dp, // Отступ сверху
                        bottom = 32.dp // Отступ снизу
                    )
                    .fillMaxSize(), // Заполняет весь доступный размер
                horizontalAlignment = Alignment.CenterHorizontally, // Центрирует элементы по горизонтали
                verticalArrangement = Arrangement.Top // Картинка вверху
            ) {
                // Картинка
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Центрируем картинку по горизонтали
                )

                // Используем Spacer для "отталкивания" кнопок вниз
                Spacer(modifier = Modifier.weight(1f)) // Заполняет оставшееся пространство

                // Кнопка "Войти"
                Button(
                    onClick = { /* Обработчик для кнопки "Войти" */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,  // Цвет кнопки
                        contentColor = MaterialTheme.colorScheme.onPrimary  // Цвет текста на кнопке
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f) // Кнопка будет занимать 80% ширины экрана
                ) {
                    Text(text = "Войти")
                }

                // Кнопка "Зарегистрироваться"
                Spacer(modifier = Modifier.height(16.dp)) // Отступ между элементами
                Button(
                    onClick = { /* Обработчик для кнопки "Зарегистрироваться" */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,  // Цвет кнопки
                        contentColor = MaterialTheme.colorScheme.onPrimary  // Цвет текста на кнопке
                    ),
                    modifier = Modifier.fillMaxWidth(0.8f) // Кнопка будет занимать 80% ширины экрана
                ) {
                    Text(text = "Зарегистрироваться")
                }
            }
        }
    }
}
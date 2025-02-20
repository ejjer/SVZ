package com.example.svz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.svz.R

@Preview
@Composable
fun RegistrationScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Отступы для всего экрана, включая верхний и нижний бар
                verticalArrangement = Arrangement.spacedBy(16.dp) // Отступы между элементами
            ) {



                // Логотип
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                )

                Image(
                    painter = painterResource(R.drawable.arrow),
                    contentDescription = "back",
                )


                // Заголовок
                Text(
                    text = "Добро пожаловать в мир су-вид!",
                    style = MaterialTheme.typography.headlineLarge, // Используем конкретный стиль заголовка
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF45624E), // Цвет заголовка
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                // Подзаголовок
                Text(
                    text = "Регистрация",
                    style = MaterialTheme.typography.titleMedium, // Используем стиль подзаголовка
                    color = Color(0xFF45624E),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                // Поле для ввода email
                OutlinedTextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Поле для ввода пароля
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Пароль") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Поле для повторного ввода пароля
                OutlinedTextField(
                    value = confirmPassword.value,
                    onValueChange = { confirmPassword.value = it },
                    label = { Text("Введите пароль еще раз") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Чекбокс для "Чужой компьютер"
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = isChecked.value,
                        onCheckedChange = { isChecked.value = it }
                    )
                    Text(text = "Чужой компьютер", modifier = Modifier.padding(start = 8.dp))
                }

                // Кнопка для регистрации
                Button(
                    onClick = { /* Обработчик для регистрации */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF45624E),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Зарегистрироваться")
                }

                // Текст с ссылкой на вход
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "У вас уже есть аккаунт? ", color = Color.Black)
                    Text(
                        text = "Войти в аккаунт",
                        color = Color(0xFF45624E),
                        modifier = Modifier.clickable { /* Обработчик для входа */ }
                    )
                }
            }
        }
    )
}
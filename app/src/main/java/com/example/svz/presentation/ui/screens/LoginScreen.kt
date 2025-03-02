package com.example.svz.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.svz.domain.models.Result
import com.example.svz.presentation.ui.theme.SVZTheme
import com.example.svz.presentation.viewModels.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }

    // Состояние входа
    val loginState by viewModel.loginState.collectAsState()

    SVZTheme {
        Scaffold(
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "С возвращением в мир су-вид!",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
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

                    // Чекбокс "Чужой компьютер"
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

                    // Кнопка входа
                    Button(
                        onClick = {
                            // Логируем нажатие кнопки
                            Log.d("LoginScreen", "Нажата кнопка входа")

                            // Вызов метода входа
                            viewModel.login(email.value, password.value)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF45624E),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Войти")
                    }

                    // Отображение состояния входа
                    when (val state = loginState) {
                        is Result.Loading -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                        is Result.Success -> {
                            Text("Вход выполнен успешно!", color = Color.Green)
                        }
                        is Result.Failure -> {
                            Text(
                                text = "Ошибка: ${state.exceptionOrNull()?.message}",
                                color = Color.Red
                            )
                        }
                        else -> {
                            // Ничего не отображаем
                        }
                    }
                }
            }
        )
    }
}
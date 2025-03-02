package com.example.svz.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.useCase.RegisterUserUseCase
import com.example.svz.domain.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    // Состояние регистрации
    private val _registerState = MutableStateFlow<Result<Unit>>(Result.Loading)
    val registerState: StateFlow<Result<Unit>> get() = _registerState

    fun register(email: String, password: String, password2: String) {
        viewModelScope.launch {
            try {
                // Логируем начало регистрации
                Log.d("RegisterViewModel", "Начало регистрации: email=$email")

                // Проверка на пустые поля
                if (email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                    val error = IllegalArgumentException("Все поля должны быть заполнены")
                    Log.e("RegisterViewModel", "Ошибка: ${error.message}")
                    _registerState.value = Result.Failure(error)
                    return@launch
                }

                // Проверка совпадения паролей
                if (password != password2) {
                    val error = IllegalArgumentException("Пароли не совпадают")
                    Log.e("RegisterViewModel", "Ошибка: ${error.message}")
                    _registerState.value = Result.Failure(error)
                    return@launch
                }

                // Устанавливаем состояние загрузки
                _registerState.value = Result.Loading

                // Вызов use case для регистрации
                registerUserUseCase(email, password, password2)
                Log.d("RegisterViewModel", "Регистрация успешна: email=$email")

                // Устанавливаем состояние успеха с типом Unit
                _registerState.value = Result.Success(Unit) // Указываем тип Unit
            } catch (e: Exception) {
                // Логируем ошибку
                Log.e("RegisterViewModel", "Ошибка регистрации: ${e.message}", e)

                // Устанавливаем состояние ошибки
                _registerState.value = Result.Failure(e)
            }
        }
    }
}
package com.example.svz.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.useCase.LoginUseCase
import com.example.svz.domain.models.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    // Состояние входа
    private val _loginState = MutableStateFlow<Result<Unit>>(Result.Loading)
    val loginState: StateFlow<Result<Unit>> get() = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                // Логируем начало входа
                Log.d("LoginViewModel", "Начало входа: email=$email")

                // Устанавливаем состояние загрузки
                _loginState.value = Result.Loading

                // Вызов use case для входа
                loginUseCase(email, password)
                Log.d("LoginViewModel", "Вход выполнен успешно: email=$email")

                // Устанавливаем состояние успеха
                _loginState.value = Result.Success(Unit)
            } catch (e: Exception) {
                // Логируем ошибку
                Log.e("LoginViewModel", "Ошибка входа: ${e.message}", e)

                // Устанавливаем состояние ошибки
                _loginState.value = Result.Failure(e)
            }
        }
    }
}
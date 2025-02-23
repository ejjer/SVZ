package com.example.svz.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.useCase.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.svz.domain.models.Result

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginState = MutableLiveData<Result<Unit>>()
    val loginState: LiveData<Result<Unit>> get() = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Result.Loading // Если у вас есть состояние загрузки
            try {
                loginUseCase(email, password)
                _loginState.value = Result.Success(Unit) // Успешный результат
            } catch (e: Exception) {
                _loginState.value = Result.Failure(e) // Ошибка
            }
        }
    }
}
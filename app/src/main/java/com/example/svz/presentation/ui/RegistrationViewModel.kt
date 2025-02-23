package com.example.svz.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.useCase.RegisterUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    private val _registerState = MutableLiveData<Result<Unit>>()
    val registerState: LiveData<Result<Unit>> get() = _registerState

    fun register(email: String, password: String, password2: String) {
        viewModelScope.launch {
            try {
                registerUserUseCase(email, password, password2)
                _registerState.postValue(Result.success(Unit))
            } catch (e: Exception) {
                _registerState.postValue(Result.failure(e))
            }
        }
    }
}
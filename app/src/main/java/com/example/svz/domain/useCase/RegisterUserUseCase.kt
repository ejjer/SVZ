package com.example.svz.domain.useCase

import com.example.svz.domain.AuthRepository

class RegisterUserUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String, password2: String) = repository.registerUser(email, password, password2)
}
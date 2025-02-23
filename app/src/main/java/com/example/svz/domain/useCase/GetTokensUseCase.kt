package com.example.svz.domain.useCase

import com.example.svz.data.repository.AuthRepositoryImpl

class GetTokensUseCase(private val repository: AuthRepositoryImpl) {
    suspend operator fun invoke(email: String, password: String) =
        repository.getTokens(email, password)
}
package com.example.svz.domain.useCase

import com.example.svz.data.repository.AuthRepositoryImpl

class RefreshTokenUseCase(private val repository: AuthRepositoryImpl) {
    suspend operator fun invoke() {
        repository.refreshToken()
    }
}
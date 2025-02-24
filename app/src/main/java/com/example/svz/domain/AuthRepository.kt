package com.example.svz.domain

import com.example.svz.domain.models.auth.TokenResponse

interface AuthRepository {
    suspend fun registerUser(email: String, password: String, password2: String)
    suspend fun login(email: String, password: String)
    suspend fun refreshToken()
    suspend fun getTokens(email: String, password: String): TokenResponse
}
package com.example.svz.data.repository

import com.example.svz.data.AuthApi
import com.example.svz.data.local.TokenManager
import com.example.svz.domain.AuthRepository
import com.example.svz.domain.models.auth.LoginRequest
import com.example.svz.domain.models.auth.RefreshRequest
import com.example.svz.domain.models.auth.RegisterRequest
import com.example.svz.domain.models.auth.TokenResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val tokenManager: TokenManager
) : AuthRepository  {
    override suspend fun registerUser(email: String, password: String, password2: String) {
        val response = api.registerUser(RegisterRequest(email, password, password2))
        if (response.isSuccessful) {
            response.body()?.let { tokenManager.saveTokens(it.access, it.refresh) }
        } else {
            throw Exception("Ошибка регистрации")
        }
    }

    override suspend fun login(email: String, password: String) {
        val response = api.login(LoginRequest(email, password))
        if (response.isSuccessful) {
            response.body()?.let { tokenManager.saveTokens(it.access, it.refresh) }
        } else {
            throw Exception("Ошибка входа")
        }
    }

    override suspend fun refreshToken() {
        val refresh = tokenManager.getRefreshToken() ?: throw Exception("Refresh token отсутствует")
        val response = api.refreshToken(RefreshRequest(refresh))
        if (response.isSuccessful) {
            response.body()?.let { tokenManager.saveAccessToken(it.access) }
        } else {
            throw Exception("Ошибка обновления токена")
        }
    }

    override suspend fun getTokens(email: String, password: String): TokenResponse {
        val response = api.login(LoginRequest(email, password))
        if (response.isSuccessful) {
            response.body()?.let { tokenManager.saveTokens(it.access, it.refresh) }
            return response.body() ?: throw Exception("Не удалось получить токены")
        } else {
            throw Exception("Ошибка получения токенов")
        }
    }
}
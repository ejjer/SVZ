package com.example.svz.data

import com.example.svz.domain.models.AccessTokenResponse
import com.example.svz.domain.models.LoginRequest
import com.example.svz.domain.models.RefreshRequest
import com.example.svz.domain.models.RegisterRequest
import com.example.svz.domain.models.RegisterResponse
import com.example.svz.domain.models.TokenRequest
import com.example.svz.domain.models.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/v1/auth/users/")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/api/v1/auth/jwt/create/")
    suspend fun login(@Body request: LoginRequest): Response<TokenResponse>

    @POST("/api/v1/auth/jwt/refresh/")
    suspend fun refreshToken(@Body request: RefreshRequest): Response<AccessTokenResponse>
}
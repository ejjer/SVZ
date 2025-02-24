package com.example.svz.domain.models.auth

data class RegisterRequest(val email: String, val password: String, val password2: String)
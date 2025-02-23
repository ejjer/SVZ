package com.example.svz.domain.models

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val exception: Throwable) : Result<Nothing>() {
        fun exceptionOrNull(): Throwable? = exception
    }
}
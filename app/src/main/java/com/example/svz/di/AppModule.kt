package com.example.svz.di

import android.content.Context
import com.example.svz.data.AuthApi
import com.example.svz.data.RecipeApi
import com.example.svz.data.local.TokenManager
import com.example.svz.data.repository.AuthRepositoryImpl
import com.example.svz.data.repository.RecipeRepositoryImpl
import com.example.svz.domain.AuthRepository
import com.example.svz.domain.RecipeRepository
import com.example.svz.domain.useCase.LoginUseCase
import com.example.svz.domain.useCase.RegisterUserUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideTokenManager(context: Context): TokenManager = TokenManager(context)

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl("http://147.45.76.77:8000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl("http://147.45.76.77:8000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(authApi: AuthApi, tokenManager: TokenManager): AuthRepository {
        return AuthRepositoryImpl(authApi, tokenManager)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(recipeApi: RecipeApi): RecipeRepository {
        return RecipeRepositoryImpl(recipeApi)
    }

    @Provides
    @Singleton
    fun provideRegisterUserUseCase(authRepository: AuthRepository): RegisterUserUseCase {
        return RegisterUserUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase {
        return LoginUseCase(authRepository)
    }
}
package com.example.svz.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.svz.domain.RecipeRepository
import com.example.svz.domain.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    // Состояние экрана
    sealed class RecipeListState {
        object Loading : RecipeListState() // Состояние загрузки
        data class Success(val recipes: List<Recipe>) : RecipeListState() // Успешная загрузка
        data class Error(val message: String) : RecipeListState() // Ошибка
    }

    // Поток для управления состоянием
    private val _state = MutableStateFlow<RecipeListState>(RecipeListState.Loading)
    val state: StateFlow<RecipeListState> get() = _state

    // Загрузка рецептов
    fun loadRecipes(page: Int = 1) {
        viewModelScope.launch {
            // Логируем начало загрузки
            Log.d("RecipeListViewModel", "Начало загрузки рецептов, страница: $page")

            _state.value = RecipeListState.Loading // Устанавливаем состояние загрузки

            try {
                // Логируем попытку загрузки данных
                Log.d("RecipeListViewModel", "Загрузка данных...")

                val recipes = repository.getPopularRecipes(page) // Загружаем данные

                // Логируем успешную загрузку
                Log.d("RecipeListViewModel", "Данные успешно загружены. Количество рецептов: ${recipes.size}")

                _state.value = RecipeListState.Success(recipes) // Устанавливаем состояние успеха
            } catch (e: Exception) {
                // Логируем ошибку
                Log.e("RecipeListViewModel", "Ошибка загрузки рецептов: ${e.message}", e)

                _state.value = RecipeListState.Error("Ошибка загрузки рецептов: ${e.message}") // Устанавливаем состояние ошибки
            }
        }
    }
}
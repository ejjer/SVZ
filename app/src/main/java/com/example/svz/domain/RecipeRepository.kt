package com.example.svz.domain

import com.example.svz.domain.models.Recipe

interface RecipeRepository {
    suspend fun getPopularRecipes(page: Int = 1): List<Recipe>
}
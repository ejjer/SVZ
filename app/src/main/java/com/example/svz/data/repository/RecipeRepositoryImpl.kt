package com.example.svz.data.repository

import com.example.svz.data.RecipeApi
import com.example.svz.domain.RecipeRepository
import com.example.svz.domain.models.Recipe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApi
) : RecipeRepository {

    override suspend fun getPopularRecipes(page: Int): List<Recipe> {
        val response = api.getPopularRecipes(page = page)
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }
}
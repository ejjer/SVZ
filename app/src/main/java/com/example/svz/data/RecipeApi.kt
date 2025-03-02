package com.example.svz.data

import com.example.svz.domain.models.PopularRecipesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("feed/")
    suspend fun getPopularRecipes(
        @Query("ordering") ordering: String = "-activity_count",
        @Query("page") page: Int = 1
    ): Response<PopularRecipesResponse>
}
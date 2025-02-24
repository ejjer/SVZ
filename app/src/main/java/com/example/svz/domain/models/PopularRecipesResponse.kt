package com.example.svz.domain.models

data class PopularRecipesResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Recipe>
)
package com.example.svz.domain.models

data class Recipe(
    val title: String,
    val time: String,
    val description: String,
    val tags: List<String>
)
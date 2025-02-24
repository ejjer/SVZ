package com.example.svz.domain.models

data class Recipe(
    val id: Int,
    val title: String,
    val slug: String,
    val author: Author,
    val previewImage: String?,
    val shortText: String,
    val tags: List<String>,
    val commentsCount: Int,
    val reactionsCount: Int,
    val viewsCount: Int,
    val category: Category,
    val cookingTime: Int,
    val pubDate: String,
    val activityCount: Int,
    val isFavorite: Boolean
)

data class Author(
    val id: Int,
    val username: String,
    val displayName: String,
    val avatar: String?
)

data class Category(
    val id: Int,
    val name: String,
    val slug: String
)
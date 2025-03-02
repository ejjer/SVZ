package com.example.svz.domain.models

import com.google.gson.annotations.SerializedName

data class Recipe(
    val id: Int,
    val title: String,
    val slug: String,
    val author: Author,
    @SerializedName("preview_image")
    val previewImage: String?,
    @SerializedName("short_text")
    val shortText: String,
    @SerializedName("tag")
    val tags: List<String>,
    @SerializedName("comments_count")
    val commentsCount: Int,
    @SerializedName("reactions_count")
    val reactionsCount: Int,
    @SerializedName("views_count")
    val viewsCount: Int,
    val category: List<Category>,
    @SerializedName("cooking_time")
    val cookingTime: Int,
    @SerializedName("pub_date")
    val pubDate: String,
    @SerializedName("activity_count")
    val activityCount: Int,
    @SerializedName("is_favorite")
    val isFavorite: Boolean
)

data class Author(
    val id: Int,
    val username: String,
    @SerializedName("display_name")
    val displayName: String?,
    val avatar: String?
)

data class Category(
    val id: Int,
    val name: String,
    val slug: String
)
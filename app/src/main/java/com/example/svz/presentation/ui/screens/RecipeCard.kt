package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.svz.R
import com.example.svz.domain.models.Recipe
import com.example.svz.presentation.ui.theme.SVZTheme

@Composable
fun RecipeCard(recipe: Recipe) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Заголовок рецепта
            Text(
                text = recipe.title, // Используем title, который является String
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Время приготовления
            Text(
                text = "Время приготовления: ${recipe.cookingTime} мин.", // Используем cookingTime, который является Int
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Изображение рецепта (если есть)
            if (recipe.previewImage != null) {
                Image(
                    painter = painterResource(R.drawable.recipe_image), // Замените на загрузку изображения из сети, если нужно
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Краткое описание рецепта
            Text(
                text = recipe.shortText, // Используем shortText, который является String
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Тэги рецепта
            Row {
                recipe.tags.forEach { tag ->
                    Text(
                        text = tag, // Используем tag, который является String
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
            }
        }
    }
}
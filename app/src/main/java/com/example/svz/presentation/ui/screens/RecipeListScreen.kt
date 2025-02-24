package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.svz.domain.models.Recipe


@Composable
fun RecipeListScreen() {
    val recipes = listOf(
        Recipe("Куриные бедра с лимонным соусом", "1 ч. 30 мин.", "Блюдо с ароматным, кисло-сладким соусом, обволакивающим каждый мясной кусочек. В соусе нет ни лука, ни чеснока, поэтому блюдо подойдет как для семейного, так и романтического ужина. Пробуйте:", listOf("#xeurrer", "#xeurrer", "#xeurrer", "#xeurrer", "#xeurrer")),
        Recipe("Куриные бедра с лимонным соусом", "1 ч. 30 мин.", "Блюдо с ароматным, кисло-сладким соусом, обволакивающим каждый мясной кусочек. В соусе нет ни лука, ни чеснока, поэтому блюдо подойдет как для семейного, так и романтического ужина. Пробуйте:", listOf("#xeurrer", "#xeurrer", "#xeurrer", "#xeurrer", "#xeurrer"))
    )

    Scaffold(
        topBar = {
            TopBar(title = "SOUS-VIDE ZEN")
        },
        bottomBar = {
            BottomBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(recipes) { recipe ->
                RecipeCard(recipe)
            }
        }
    }
}
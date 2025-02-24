package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.svz.presentation.viewModels.RecipeListViewModel
import com.example.svz.presentation.ui.screens.TopBar
import com.example.svz.presentation.ui.screens.BottomBar
import com.example.svz.presentation.ui.screens.RecipeCard
import com.example.svz.domain.models.Recipe
import androidx.compose.material3.MaterialTheme


@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = viewModel()
) {
    val recipes by viewModel.recipes.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRecipes()
    }

    Scaffold(
        topBar = {
            TopBar(title = "Популярные рецепты")
        },
        bottomBar = {
            BottomBar()
        }
    ) { paddingValues ->
        if (isLoading) {
            // Покажите индикатор загрузки по центру экрана
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (error != null) {
            // Покажите сообщение об ошибке
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = error!!, color = MaterialTheme.colorScheme.error)
            }
        } else {
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
}
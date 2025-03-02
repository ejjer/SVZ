package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.svz.App
import com.example.svz.presentation.viewModels.RecipeListViewModel

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = viewModel(
        factory = (LocalContext.current.applicationContext as App)
            .appComponent
            .getViewModelFactory()
    )
) {
    // Состояние экрана
    val state by viewModel.state.collectAsState()

    // Автоматическая загрузка рецептов при открытии экрана
    LaunchedEffect(Unit) {
        viewModel.loadRecipes()
    }

    // Отображение UI в зависимости от состояния
    Scaffold(
        topBar = { TopBar(title = "Популярные рецепты") },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        when (val currentState = state) {
            is RecipeListViewModel.RecipeListState.Loading -> {
                // Отображение индикатора загрузки
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is RecipeListViewModel.RecipeListState.Success -> {
                // Отображение списка рецептов
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    items(currentState.recipes) { recipe ->
                        RecipeCard(recipe)
                    }
                }
            }
            is RecipeListViewModel.RecipeListState.Error -> {
                // Отображение ошибки
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = currentState.message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
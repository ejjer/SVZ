package com.example.svz.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.svz.R
import com.example.svz.presentation.ui.theme.SVZTheme


@Composable
fun StartScreen(navController: NavController) {
    SVZTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(top = 64.dp, bottom = 32.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(text = "Войти")
                }


                Button(
                    onClick = { navController.navigate("registration") },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(text = "Зарегистрироваться")
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Текстовая кнопка "Продолжить без регистрации"
                TextButton(
                    onClick = { navController.navigate("recipeList") }, // Навигация на RecipeListScreen
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(
                        text = "Продолжить без регистрации",
                        color = MaterialTheme.colorScheme.primary // Используйте цвет из темы
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    SVZTheme {
        StartScreen(navController = rememberNavController())
    }
}
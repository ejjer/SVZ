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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.svz.R
import com.example.svz.presentation.ui.theme.SVZTheme

@Preview
@Composable
fun RecipeCard() {
    SVZTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),

            ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Куриные бедра с лимонным соусом",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "1 ч. 30 мин.",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Замените на ваше изображение, если оно есть
                Image(
                    painter = painterResource(R.drawable.recipe_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Блюдо с ароматным, кисло-сладким соусом, обволакивающим каждый мясной кусочек. В соусе нет ни лука, ни чеснока, поэтому блюдо подойдет как для семейного, так и романтического ужина. Пробуйте:",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "#хэштэг",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
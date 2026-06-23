package com.pdm.laboratorio6.ui.screens

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pdm.laboratorio6.ui.viewModel.MealViewModel
import  androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import coil.compose.AsyncImage

import androidx.compose.foundation.lazy.items



@Composable
fun MealScreen(
    viewModel: MealViewModel = viewModel()
) {
    val meal by viewModel.meals.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadMeals()
    }

    when {
        isLoading -> {
            CircularProgressIndicator()
        }
        else -> {
            LazyColumn {
                items(meal) { meal ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = meal.name)
                            Text(text = meal.category)
                            Text(text = meal.area)
                            AsyncImage(
                                model = meal.imageUrl,
                                contentDescription = meal.name,
                                modifier = Modifier.fillMaxWidth()
                            )

                        }
                    }
                }
            }
        }
    }
}

package com.pdm.laboratorio6.data.repository

import com.pdm.laboratorio6.data.model.Meal

interface MealRepository {
    suspend fun getMeal(): Result<List<Meal>>
}
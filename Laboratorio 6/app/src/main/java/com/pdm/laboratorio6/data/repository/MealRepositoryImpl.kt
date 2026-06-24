package com.pdm.laboratorio6.data.repository

import com.pdm.laboratorio6.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.pdm.laboratorio6.data.api.KtorClient
import com.pdm.laboratorio6.data.api.toModel
import com.pdm.laboratorio6.data.api.MealsResponse



class MealRepositoryImpl : MealRepository {

    override suspend fun getMeal(): Result<List<Meal>> {
        return try {
            val response: MealsResponse = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body()

            val meals = response.meals?.map { it.toModel() } ?: emptyList()
            Result.success(meals)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

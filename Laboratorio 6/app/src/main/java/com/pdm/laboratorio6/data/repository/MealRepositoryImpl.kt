package com.pdm.laboratorio6.data.repository

import com.pdm.laboratorio6.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.pdm.laboratorio6.data.api.KtorClient
import com.pdm.laboratorio6.data.api.MealDto
import com.pdm.laboratorio6.data.api.toModel



class MealRepositoryImpl : MealRepository {

    override suspend fun getMeal(): Result<List<Meal>> {
        return try {
            val Meal = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<List<MealDto>>()
                .map { it.toModel() }
            Result.success(Meal)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
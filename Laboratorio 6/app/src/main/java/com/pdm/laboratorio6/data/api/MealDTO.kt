package com.pdm.laboratorio6.data.api

import kotlinx.serialization.Serializable
import com.pdm.laboratorio6.data.model.Meal


@Serializable
data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)

// Wrapper: la API devuelve un objeto con la lista adentro
@Serializable
data class MealsResponse(
    val meals: List<MealDto>?
)

// Mapper
fun MealDto.toModel() = Meal(
    id = idMeal,
    name = strMeal,
    category = strCategory,
    area = strArea,
    imageUrl = strMealThumb
)

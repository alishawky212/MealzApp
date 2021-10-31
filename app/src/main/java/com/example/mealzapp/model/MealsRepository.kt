package com.example.mealzapp.model

import com.example.mealzapp.api.ApiClient
import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: ApiClient = ApiClient()) {

    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMealsApi().getMeals()
    }
}
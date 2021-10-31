package com.example.mealzapp.api

import com.example.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.http.GET

interface MealsApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}
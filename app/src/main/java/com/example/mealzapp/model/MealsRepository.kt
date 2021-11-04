package com.example.mealzapp.model

import com.example.mealzapp.api.ApiClient
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: ApiClient = ApiClient()) {

    private var cashedMeal = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMealsApi().getMeals()
        cashedMeal = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cashedMeal.firstOrNull {
            it.id == id
        }
    }

    //Bad Practice
    companion object{
        @Volatile
        private var instance: MealsRepository? = null
        fun getInstance() = instance?: synchronized(this){
            instance ?: MealsRepository().also {
                instance = it
            }
        }
    }
}
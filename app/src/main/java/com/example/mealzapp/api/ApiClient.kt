package com.example.mealzapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val retrofitClient: Retrofit by lazy {
        getClient()
    }

    private fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getMealsApi(): MealsApi =
        retrofitClient.create(MealsApi::class.java)
}
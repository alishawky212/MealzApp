package com.example.mealzapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse

class MealDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository: MealsRepository = MealsRepository.getInstance()
    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}
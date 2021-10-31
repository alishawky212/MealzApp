package com.example.mealzapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    val meals: MutableState<List<MealResponse>> = mutableStateOf(emptyList())
    // create our own scope
    // private val job = Job()
    //val scope = CoroutineScope(job + Dispatchers.IO)
//        scope.launch {
//            getMeals()
//        }

    init {

        viewModelScope.launch(Dispatchers.IO) {
            meals.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        //job.cancel()
    }
}
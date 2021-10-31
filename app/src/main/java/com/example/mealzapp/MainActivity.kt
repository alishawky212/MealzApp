package com.example.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mealzapp.screens.MealsCategoriesScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}


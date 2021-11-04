package com.example.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.screens.MealDetailScreen
import com.example.mealzapp.screens.MealsCategoriesScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodiezApp()
            }
        }
    }

    @Composable
    private fun FoodiezApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "destinations_meals_list") {
            composable(route = "destinations_meals_list") {
                MealsCategoriesScreen() { mealId ->
                    navController.navigate(route = "destinations_meal_detail/$mealId")
                }
            }
            composable(
                route = "destinations_meal_detail/{meal_category_id}",
                arguments = listOf(navArgument("meal_category_id") {
                    type = NavType.StringType
                })
            ) {
                val viewModel: MealDetailViewModel = viewModel()
                MealDetailScreen(mealResponse = viewModel.mealState.value!!)
            }
        }
    }
}


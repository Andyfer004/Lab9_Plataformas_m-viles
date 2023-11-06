package com.zezzi.eventzezziapp.ui.meals.view

import MealsRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse


class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            val response = repository.getMeals()
            // Agregar registro de depuración para verificar la respuesta
            Log.d("MealsCategoriesViewModel", "Response: $response")
            response
        } catch (e: Exception) {
            null

        }
    }



}




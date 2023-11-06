package com.zezzi.eventzezziapp.ui.meals.view

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.repository.DishRepository


class DishesCategoriesViewModel(private val repository: DishRepository = DishRepository()): ViewModel() {
    suspend fun getDishes(mealName: String): DishCategoriesResponse? {
        return try {
            val response = repository.getDishes(mealName)
            // Agregar registro de depuración para verificar la respuesta
            Log.d("DishesCategoriesViewModel", "Response for category $mealName: $response")
            response
        } catch (e: Exception) {
            // Manejar errores si es necesario.
            null
        }
    }



}

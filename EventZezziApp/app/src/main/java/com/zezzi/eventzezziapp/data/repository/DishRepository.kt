package com.zezzi.eventzezziapp.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.response.DishCategoriesResponse
import com.zezzi.eventzezziapp.data.networking.response.DishResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class DishRepository {

    private val db = Firebase.firestore
    suspend fun getDishes(mealName: String): DishCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val documents = db.collection("Meals")
                    .document(mealName).collection("Dishes")
                    .get().await().documents

                DishCategoriesResponse(
                    documents.map {
                        DishResponse(
                            it.getString("name1") ?: "",
                            it.getString("imageUrl2") ?: "",

                        )
                    })
            } catch (e: Exception) {
                null
            }
        }
    }



}
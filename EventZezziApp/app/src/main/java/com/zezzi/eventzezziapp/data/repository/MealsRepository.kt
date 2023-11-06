
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.data.networking.response.CategoryResponse
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MealsRepository {

    private val db = Firebase.firestore
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el webService para obtener los datos.
                val categories = db.collection("Meals").get().await().documents

               MealsCategoriesResponse(categories.map {
                    CategoryResponse(
                        it.id,
                        it.getString("name")?:"" ,
                        it.getString("description") ?:"" ,
                        it.getString("imageUrl") ?:""
                    )
                })

            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }



}

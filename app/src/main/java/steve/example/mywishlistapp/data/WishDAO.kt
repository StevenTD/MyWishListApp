package steve.example.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// An Abstract class is a class that has method that don't need implementations
@Dao
abstract class WishDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish-table` ")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update()
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete()
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish-table` WHERE id= :id")
    abstract fun getAWishById(id: Long): Flow<Wish>
}
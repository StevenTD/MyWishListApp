package steve.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import steve.example.mywishlistapp.data.WishDatabase
import steve.example.mywishlistapp.data.WishRepository

object Graph { // Service locator for all application
    lateinit var database: WishDatabase

    val wishRepository by lazy{ // By lazy, initialize once only needed and only once
        WishRepository(
            wishDao = database.wishDao()
        )

    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}
package com.example.viewmodelrepositoryexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass

/**
 *Jangan lupa anotasi-anotasi wajibnya. Pasang data class yang telah memiliki @Entity ke dalam parameter dengan nama variabel "entities".
 */
@Database(entities = [CatDataClass::class], version = 1)
abstract class FavoriteCatRoomDatabase : RoomDatabase() {
    abstract fun favoriteCatDao(): FavoriteCatDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteCatRoomDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): FavoriteCatRoomDatabase {
            if (INSTANCE == null) {
                synchronized(FavoriteCatRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteCatRoomDatabase::class.java, "vmre_database"
                    )
                        .build()
                }
            }
            return INSTANCE as FavoriteCatRoomDatabase
        }
    }
}
package com.example.viewmodelrepositoryexample.data.repository

import android.content.Context
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass
import com.example.viewmodelrepositoryexample.db.FavoriteCatDao
import com.example.viewmodelrepositoryexample.db.FavoriteCatRoomDatabase

class FavoriteCatRepository(private val favoriteCatDao: FavoriteCatDao) {
    fun getAllFavoriteCats() = favoriteCatDao.getAllFavoriteCats()

    fun getFavoriteCat(id: String) = favoriteCatDao.getFavoriteCat(id)

    suspend fun insertFavoriteCat(catDataClass: CatDataClass) {
        favoriteCatDao.insertFavoriteCat(catDataClass)
    }

    suspend fun deleteFavoriteCat(catDataClass: CatDataClass) {
        favoriteCatDao.deleteFavoriteCat(catDataClass)
    }

    companion object {

        private var INSTANCE: FavoriteCatRepository? = null

        fun getInstance(context: Context): FavoriteCatRepository {
            if (INSTANCE == null) {
                val favoriteCatRoomDatabase = FavoriteCatRoomDatabase.getInstance(context)
                INSTANCE = FavoriteCatRepository(favoriteCatRoomDatabase.favoriteCatDao())
            }

            return INSTANCE!!
        }

    }
}
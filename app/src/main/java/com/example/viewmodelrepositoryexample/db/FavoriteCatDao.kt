package com.example.viewmodelrepositoryexample.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass

/**
 *Kelas DAO bertujuan untuk melakukan pemanggilan query ke RoomDatabase.
 */
@Dao
interface FavoriteCatDao {
    @Query("SELECT * from favorite_cats ORDER BY id ASC")
    fun getAllFavoriteCats(): LiveData<List<CatDataClass>>

    @Query("SELECT * from favorite_cats WHERE id=:id")
    fun getFavoriteCat(id: String): LiveData<CatDataClass>

    @Query("SELECT EXISTS(SELECT * from favorite_cats WHERE id=:id)")
    suspend fun getIsFavoriteCat(id: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteCat(catDataClass: CatDataClass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllFavoriteCats(catDataClassList: List<CatDataClass>)

    @Delete
    suspend fun deleteFavoriteCat(catDataClass: CatDataClass)

    @Query("DELETE FROM favorite_cats")
    suspend fun deleteAllFavoriteCats()
}
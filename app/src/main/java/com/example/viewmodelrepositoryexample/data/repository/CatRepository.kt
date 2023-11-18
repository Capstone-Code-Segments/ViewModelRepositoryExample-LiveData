package com.example.viewmodelrepositoryexample.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.viewmodelrepositoryexample.data.ResultState
import com.example.viewmodelrepositoryexample.data.remote.ApiConfig
import com.example.viewmodelrepositoryexample.data.remote.ApiService
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass
import com.example.viewmodelrepositoryexample.db.FavoriteCatDao
import com.example.viewmodelrepositoryexample.db.FavoriteCatRoomDatabase

class CatRepository(
    private val apiService: ApiService,
    private val favoriteCatDao: FavoriteCatDao
) {
    /**
     * Fungsi ini akan dipanggil oleh fungsi getRandomCatList() di halaman CatViewModel
     *
     * Tipe data: LiveData<ResultState<List<CatDataClass>>>
     */
    fun getRandomCatList(): LiveData<ResultState<List<CatDataClass>>> = liveData {
        // Loading
        emit(ResultState.Loading)
        try {
            // Mendapatkan API response dengan tipe data List<CatItemResponse>
            val response = apiService.getRandomCatList()

            // Transisi tipe data dari List<CatItemResponse> ke List<CatDataClass>
            val catDataClassList = response.map { cat ->
                val isFavorite = favoriteCatDao.getIsFavoriteCat(cat.id)

                CatDataClass(
                    cat.id,
                    cat.url,
                    cat.width,
                    cat.height,
                    isFavorite
                )
            }

            // Mengirimkan data list CatDataClass dalam ResultState.Success
            emit(ResultState.Success(catDataClassList))
        } catch (e: Exception) {
            // Gagal
            emit(ResultState.Error(e.message.toString()))
        }
    }

    companion object {

        private var INSTANCE: CatRepository? = null

        fun getInstance(context: Context): CatRepository {
            if (INSTANCE == null) {
                val apiService = ApiConfig.getApiService()
                val favoriteCatRoomDatabase = FavoriteCatRoomDatabase.getInstance(context)
                INSTANCE = CatRepository(apiService, favoriteCatRoomDatabase.favoriteCatDao())
            }

            return INSTANCE!!
        }

    }
}
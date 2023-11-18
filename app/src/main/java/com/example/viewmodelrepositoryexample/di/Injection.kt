package com.example.viewmodelrepositoryexample.di

import android.content.Context
import com.example.viewmodelrepositoryexample.data.remote.ApiConfig
import com.example.viewmodelrepositoryexample.data.repository.CatRepository
import com.example.viewmodelrepositoryexample.data.repository.FavoriteCatRepository

object Injection {
    /**
     * Fungsi ini akan dipanggil oleh kelas extends ViewModel yang membutuhkan parameter dengan tipe data nama Repository di dalam ViewModelFactory
     *
     * Injeksi-injeksi seperti ini dapat digunakan kembali oleh kelas-kelas yang membutuhkan parameter dengan tipe data nama Repository
     */
    fun provideCatRepository(context: Context): CatRepository {
        return CatRepository.getInstance(context)
    }

    fun provideFavoriteCatRepository(context: Context): FavoriteCatRepository {
        val apiService = ApiConfig.getApiService()
        return FavoriteCatRepository.getInstance(context)
    }
}
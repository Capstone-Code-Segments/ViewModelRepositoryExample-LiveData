package com.example.viewmodelrepositoryexample.di

import android.content.Context
import com.example.viewmodelrepositoryexample.data.remote.ApiConfig
import com.example.viewmodelrepositoryexample.data.repository.CatRepository

object Injection {
    /**
     * Fungsi ini akan dipanggil oleh kelas extends ViewModel yang membutuhkan parameter dengan tipe data CatRepository di dalam ViewModelFactory
     *
     * Injeksi seperti ini dapat digunakan kembali oleh kelas-kelas yang membutuhkan parameter dengan tipe data CatRepository
     */
    fun provideCatRepository(context: Context): CatRepository {
        val apiService = ApiConfig.getApiService()
        return CatRepository(apiService)
    }
}
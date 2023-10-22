package com.example.viewmodelrepositoryexample.di

import android.content.Context
import com.example.viewmodelrepositoryexample.data.remote.ApiConfig
import com.example.viewmodelrepositoryexample.data.repository.CatRepository

object Injection {
    fun provideCatRepository(context: Context): CatRepository {
        val apiService = ApiConfig.getApiService()
        return CatRepository(apiService)
    }
}
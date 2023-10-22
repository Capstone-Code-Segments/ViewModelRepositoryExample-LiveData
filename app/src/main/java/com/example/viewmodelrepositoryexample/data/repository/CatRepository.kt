package com.example.viewmodelrepositoryexample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.viewmodelrepositoryexample.data.ResultState
import com.example.viewmodelrepositoryexample.data.remote.ApiService
import com.example.viewmodelrepositoryexample.data.response.CatItemResponse

class CatRepository(
    private val apiService: ApiService
) {
    //
    fun getRandomCatList(): LiveData<ResultState<List<CatItemResponse>>> = liveData {
        emit(ResultState.Loading)
        try {
            val response = apiService.getRandomCatList()
            val articles = response
            emit(ResultState.Success(articles))
        } catch (e: Exception) {
            emit(ResultState.Error(e.message.toString()))
        }
    }
}
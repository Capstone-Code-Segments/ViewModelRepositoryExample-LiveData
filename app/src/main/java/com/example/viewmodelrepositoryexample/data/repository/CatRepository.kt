package com.example.viewmodelrepositoryexample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.viewmodelrepositoryexample.data.ResultState
import com.example.viewmodelrepositoryexample.data.remote.ApiService
import com.example.viewmodelrepositoryexample.data.response.CatItemResponse

class CatRepository(
    private val apiService: ApiService
) {
    /**
     * Fungsi ini akan dipanggil oleh fungsi getRandomCatList() di halaman CatViewModel
     *
     * Tipe data: LiveData<ResultState<List<CatItemResponse>>>
     */
    fun getRandomCatList(): LiveData<ResultState<List<CatItemResponse>>> = liveData {
        // Loading
        emit(ResultState.Loading)
        try {
            val response = apiService.getRandomCatList()

            // Mengirimkan data dari API ketika sukses
            emit(ResultState.Success(response))
        } catch (e: Exception) {
            // Gagal
            emit(ResultState.Error(e.message.toString()))
        }
    }
}
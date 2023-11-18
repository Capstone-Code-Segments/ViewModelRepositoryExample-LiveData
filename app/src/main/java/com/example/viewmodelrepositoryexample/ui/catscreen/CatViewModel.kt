package com.example.viewmodelrepositoryexample.ui.catscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelrepositoryexample.data.ResultState
import com.example.viewmodelrepositoryexample.data.repository.CatRepository
import com.example.viewmodelrepositoryexample.data.response.CatItemResponse
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass

class CatViewModel(private val catRepository: CatRepository) : ViewModel() {

    /**
     * Fungsi ini akan dipanggil oleh halaman CatActivity
     */
    fun getRandomCatList(): LiveData<ResultState<List<CatDataClass>>> = catRepository.getRandomCatList()
}
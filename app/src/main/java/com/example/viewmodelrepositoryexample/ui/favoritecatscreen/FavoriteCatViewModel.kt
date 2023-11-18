package com.example.viewmodelrepositoryexample.ui.favoritecatscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelrepositoryexample.data.repository.FavoriteCatRepository
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass
import kotlinx.coroutines.launch

class FavoriteCatViewModel(private val favoriteCatRepository: FavoriteCatRepository) : ViewModel() {
    fun getAllFavoriteCats() = favoriteCatRepository.getAllFavoriteCats()

    fun getFavoriteCat(id: String) = favoriteCatRepository.getFavoriteCat(id)

    fun insertFavoriteCat(catDataClass: CatDataClass) {
        viewModelScope.launch {
            favoriteCatRepository.insertFavoriteCat(catDataClass)
        }
    }

    fun deleteFavoriteCat(catDataClass: CatDataClass) {
        viewModelScope.launch {
            favoriteCatRepository.deleteFavoriteCat(catDataClass)
        }
    }
}
package com.example.viewmodelrepositoryexample.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelrepositoryexample.di.Injection
import com.example.viewmodelrepositoryexample.ui.catscreen.CatViewModel
import com.example.viewmodelrepositoryexample.ui.favoritecatscreen.FavoriteCatViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CatViewModel(Injection.provideCatRepository(context)) as T
        }
        else if (modelClass.isAssignableFrom(FavoriteCatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteCatViewModel(Injection.provideFavoriteCatRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
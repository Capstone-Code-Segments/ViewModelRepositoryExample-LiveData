package com.example.viewmodelrepositoryexample.ui.favoritecatscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodelrepositoryexample.databinding.ActivityFavoriteCatBinding

class FavoriteCatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }
}
package com.example.viewmodelrepositoryexample.ui.catscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelrepositoryexample.adapter.CatAdapter
import com.example.viewmodelrepositoryexample.data.ResultState
import com.example.viewmodelrepositoryexample.databinding.ActivityCatBinding
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass
import com.example.viewmodelrepositoryexample.ui.ViewModelFactory
import com.example.viewmodelrepositoryexample.ui.favoritecatscreen.FavoriteCatViewModel

class CatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatBinding
    private val catViewModel by viewModels<CatViewModel> {
        ViewModelFactory(this)
    }
    private val favoriteCatViewModel by viewModels<FavoriteCatViewModel> {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catAdapter = CatAdapter()
        catAdapter.onClickInsertOrDeleteFavoriteCat = { cat ->
            if (cat.isFavorite) {
                // Akan menghapus dari daftar favorite apabila item cat, yang telah masuk ke dalam daftar favorite, diklik tombol favorite-nya
                favoriteCatViewModel.deleteFavoriteCat(cat)
                cat.isFavorite = false
            } else {
                // Akan memasukkan ke dalam daftar favorite apabila item cat, yang belum masuk ke dalam daftar favorite, diklik tombol favorite-nya
                favoriteCatViewModel.insertFavoriteCat(
                    CatDataClass(
                        cat.id,
                        cat.url,
                        cat.width,
                        cat.height,
                        true
                    )
                )

                cat.isFavorite = true
            }
        }

        binding.rvListCat.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = catAdapter
        }

        catViewModel.getRandomCatList().observe(this) { result ->
            if (result != null) {
                when (result) {
                    is ResultState.Loading -> {
                        // Menampilkan simbol loading
                    }

                    is ResultState.Success -> {
                        // Menghilangkan simbol loading dan menampilkan hasil (di sini langsung menampilkan hasil)

                        val catListResponse = result.data

                        catAdapter.submitList(catListResponse)
                    }

                    is ResultState.Error -> {
                        // Menghilangkan simbol loading dan menampilkan pesan eror
                    }
                }
            }
        }
    }
}
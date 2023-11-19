package com.example.viewmodelrepositoryexample.ui.favoritecatscreen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelrepositoryexample.adapter.CatAdapter
import com.example.viewmodelrepositoryexample.databinding.ActivityFavoriteCatBinding
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass
import com.example.viewmodelrepositoryexample.ui.ViewModelFactory

class FavoriteCatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteCatBinding
    private val favoriteCatViewModel by viewModels<FavoriteCatViewModel> {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

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

        favoriteCatViewModel.getAllFavoriteCats().observe(this) { result ->
            if (result != null) {
                catAdapter.submitList(result)
            }
        }
    }
}
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

class CatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatBinding
    private val catViewModel by viewModels<CatViewModel> {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catAdapter = CatAdapter()

        binding?.rvListCat?.apply {
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

                        val catList = catListResponse.map { item ->
                            CatDataClass(
                                item.id,
                                item.url,
                                item.width,
                                item.height,
                            )
                        }

                        catAdapter.submitList(catList)
                    }

                    is ResultState.Error -> {
                        // Menghilangkan simbol loading dan menampilkan pesan eror
                    }
                }
            }
        }
    }
}
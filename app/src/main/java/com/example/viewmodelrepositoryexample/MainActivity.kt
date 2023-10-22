package com.example.viewmodelrepositoryexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelrepositoryexample.databinding.ActivityMainBinding
import com.example.viewmodelrepositoryexample.ui.catscreen.CatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@MainActivity, CatActivity::class.java)

        startActivity(intent)

        finish()
    }
}
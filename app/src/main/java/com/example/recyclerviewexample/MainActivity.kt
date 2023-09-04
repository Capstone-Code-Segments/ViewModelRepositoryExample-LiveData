package com.example.recyclerviewexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi array name dan description
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)

        // Inisialisasi ArrayList Hero; dan masukkan masing-masing name dan description ke dalam ArrayList ini
        val heroList = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i])
            heroList.add(hero)
        }

        // Inisialisasi recyclerView dari xml-nya
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_heroes)

        // Jangan lupa
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inisialisasi adapter
        val adapterClass = Adapter(heroList)

        // Alur untuk variabel "onClickToDetailActivity"
        adapterClass.onClickToDetailActivity = { name, description ->
            // Contoh saja, Toast ini betrtujuan untuk menampilkan nama pahlawan
            Toast.makeText(this@MainActivity, "Name: $name", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, DetailActivity::class.java)

            startActivity(intent)
        }

        // Jangan lupa
        recyclerView.adapter = adapterClass
    }
}
package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Jangan lupa semua bagian mesti dipasang, termasuk interfacenya
class Adapter(private val heroList: ArrayList<Hero>) :
    RecyclerView.Adapter<Adapter.RecyclerViewHolder>() {
    // Variabel "onClickToDetailActivity" dengan 2 parameter dengan tipe data "String" semuanya
    lateinit var onClickToDetailActivity: (String, String) -> Unit

    // Class RecyclerViewHolder dan extend-nya, masing-masing butuh constructor dengan tipe data "View"
    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Inisialisasi tiap komponen pada layout item
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Inisialisasi Class RecyclerViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return RecyclerViewHolder(
            view
        )
    }

    // Untuk item tertentu
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val name = heroList[position].name
        val description = heroList[position].description

        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            // Panggil variabel "onClickToDetailActivity" dengan parameter-parameternya
            onClickToDetailActivity(name, description)
        }
    }

    // Ukuran dari list yang ingin ditampilkan
    override fun getItemCount(): Int {
        return heroList.size
    }
}
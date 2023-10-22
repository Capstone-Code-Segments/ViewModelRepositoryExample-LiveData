package com.example.viewmodelrepositoryexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewmodelrepositoryexample.databinding.ItemCatBinding
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass

class CatAdapter : ListAdapter<CatDataClass, CatAdapter.CatViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    class CatViewHolder(private val binding: ItemCatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CatDataClass) {
            Glide.with(itemView.context)
                .load(data.url)
                .into(binding.ivItemCat)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatDataClass>() {
            override fun areItemsTheSame(oldItem: CatDataClass, newItem: CatDataClass): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CatDataClass, newItem: CatDataClass): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
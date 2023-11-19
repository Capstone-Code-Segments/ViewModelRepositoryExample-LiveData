package com.example.viewmodelrepositoryexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewmodelrepositoryexample.R
import com.example.viewmodelrepositoryexample.databinding.ItemCatBinding
import com.example.viewmodelrepositoryexample.dataclass.CatDataClass

class CatAdapter : ListAdapter<CatDataClass, CatAdapter.CatViewHolder>(DIFF_CALLBACK) {
    lateinit var onClickInsertOrDeleteFavoriteCat: (CatDataClass) -> Unit

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

    inner class CatViewHolder(private val binding: ItemCatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catDataClass: CatDataClass) {
            Glide.with(itemView.context)
                .load(catDataClass.url)
                .into(binding.ivItemCat)

            if (catDataClass.isFavorite) {
                binding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(binding.ivFavorite.context, R.drawable.ic_red_heart_filled))
            } else {
                binding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(binding.ivFavorite.context, R.drawable.ic_red_heart_outlined))
            }

            binding.ivFavorite.setOnClickListener {
                onClickInsertOrDeleteFavoriteCat(catDataClass)

                if (catDataClass.isFavorite) {
                    binding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(binding.ivFavorite.context, R.drawable.ic_red_heart_filled))
                } else {
                    binding.ivFavorite.setImageDrawable(ContextCompat.getDrawable(binding.ivFavorite.context, R.drawable.ic_red_heart_outlined))
                }
            }
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
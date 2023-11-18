package com.example.viewmodelrepositoryexample.dataclass

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 *Data class ini akan dibuat sebagai objek yang akan digunakan dalam RoomDatabase. Jangan lupa anotasi-anotasi wajibnya.
 */
@Entity(tableName = "favorite_cats")
@Parcelize
data class CatDataClass(
    /**
     *Primary key bisa lebih dari satu; primary key lebih dari satu disebut composite primary key.
     */
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "width")
    val width: Int,

    @ColumnInfo(name = "height")
    val height: Int,

    @field:ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean
) : Parcelable
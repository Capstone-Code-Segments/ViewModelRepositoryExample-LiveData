package com.example.viewmodelrepositoryexample.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatDataClass(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
) : Parcelable
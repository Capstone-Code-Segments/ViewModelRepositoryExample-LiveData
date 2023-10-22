package com.example.viewmodelrepositoryexample.data.response

import com.google.gson.annotations.SerializedName

data class CatItemResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("width")
    val width: Int,

    @field:SerializedName("height")
    val height: Int,
)
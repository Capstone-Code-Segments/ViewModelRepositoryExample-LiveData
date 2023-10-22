package com.example.viewmodelrepositoryexample.data.remote

import com.example.viewmodelrepositoryexample.data.response.CatItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("images/search")
    suspend fun getRandomCatList(): List<CatItemResponse>
}

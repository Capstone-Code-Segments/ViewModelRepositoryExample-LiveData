package com.example.viewmodelrepositoryexample.data.remote

import com.example.viewmodelrepositoryexample.data.response.CatItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * Mengambil 20 random gambar kucing
     * Data dari backend: GET, pakai query (key: limit, value dalam integer (1-100))
     */
    @GET("images/search")
    suspend fun getRandomCatList(@Query("limit") limit: Int = 20): List<CatItemResponse>
}

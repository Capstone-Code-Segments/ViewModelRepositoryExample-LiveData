package com.example.viewmodelrepositoryexample.data.remote

import com.example.viewmodelrepositoryexample.data.response.CatItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * Fungsi ini akan mengambil 20 gambar kucing secara random (dalam bentuk list)
     *
     * Perintah dari backend: GET
     *
     * Parameter: query (key: limit, value dalam integer (1-100))
     */
    @GET("images/search")
    suspend fun getRandomCatList(@Query("limit") limit: Int = 20): List<CatItemResponse>
}

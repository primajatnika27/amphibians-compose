package com.prima.amphibians.network

import com.prima.amphibians.model.Amphibians
import retrofit2.http.GET

interface ApiService {

    @GET("amphibians")
    suspend fun getListAmphibians(): List<Amphibians>
}
package com.sample.composetutorial.dependency_injection.network

import com.sample.composetutorial.dependency_injection.model.NewsApi
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL: String = "https://newsapi.org/v2/"
    }

    @GET("top-headlines")
    suspend fun newsByCategory(
        @Query("category") category: String,
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = "f60f73b2ace542dda1c48f9f10f17a3d",
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsApi
}
package com.project.kumber

import com.project.kumber.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("v2/top-headlines")
    suspend fun getIndonesiaNews(
        @Query("country")
        countryCode: String = "id",
        @Query("apiKey")
        apiKey: String = "8fde604cd9734b1b955c234ee733f3a2"
    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun getAmericaNews(
        @Query("country")
        countryCode: String = "us",
        @Query("apiKey")
        apiKey: String = "8fde604cd9734b1b955c234ee733f3a2"
    ): Response<NewsResponse>
}
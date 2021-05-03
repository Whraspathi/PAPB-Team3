package com.project.kumber.api

import com.project.kumber.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getIndonesiaBreakingNews(
            @Query("country")
            countryCode: String = "id",
            @Query("page")
            pageNumber: Int = 1,
            @Query("apiKey")
            apiKey: String = "8fde604cd9734b1b955c234ee733f3a2"
    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun getLuarNegeriBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = "8fde604cd9734b1b955c234ee733f3a2"
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
            @Query("q")
            searchQuery: String,
            @Query("page")
            pageNumber: Int = 1,
            @Query("apiKey")
            apiKey: String = "8fde604cd9734b1b955c234ee733f3a2"
    ): Response<NewsResponse>
}
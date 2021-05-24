package com.project.kumber.repository

import com.project.kumber.api.RetrofitInstance
import com.project.kumber.db.ArticleDatabase
import java.time.temporal.TemporalQuery

class NewsRepository (
    val db: ArticleDatabase
    )
{
    suspend fun getIndonesiaBreakingNews(countryCode : String, pageNumber : Int) =
        RetrofitInstance.api.getIndonesiaBreakingNews(countryCode, pageNumber)

    suspend fun getLuarNegeriBreakingNews(countryCode : String, pageNumber : Int) =
        RetrofitInstance.api.getLuarNegeriBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}
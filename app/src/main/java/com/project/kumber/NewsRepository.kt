package com.project.kumber

import com.project.kumber.api.RetrofitInstance
import com.project.kumber.db.ArticleDatabase

class NewsRepository (
    val db: ArticleDatabase
    )
{
    suspend fun getIndonesiaBreakingNews(countryCode : String, pageNumber : Int) =
        RetrofitInstance.api.getIndonesiaBreakingNews(countryCode, pageNumber)
}
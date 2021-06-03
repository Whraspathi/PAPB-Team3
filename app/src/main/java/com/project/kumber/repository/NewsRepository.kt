package com.project.kumber.repository

import com.project.kumber.api.RetrofitInstance
import com.project.kumber.db.ArticleDatabase
import com.project.kumber.model.Article
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

    suspend fun update(article: Article) = db.getArticleDao().update(article)

    fun getSavedNews() = db.getArticleDao().getArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
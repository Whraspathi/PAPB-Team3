package com.project.kumber.model

import com.project.kumber.model.Article

data class NewsResponse(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)
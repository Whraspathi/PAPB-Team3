package com.project.kumber.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.kumber.Resource
import com.project.kumber.model.Article
import com.project.kumber.model.NewsResponse
import com.project.kumber.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel (
    val newsRepository: NewsRepository
    ) : ViewModel()
{
    val indonesiaBreakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var indonesiaBreakingNewsPage = 1
    var indonesiaBreakingNewsResponse: NewsResponse? = null

    val internasionalBreakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var internasionalBreakingNewsPage = 1
    var internasionalBreakingNewsResponse: NewsResponse? = null

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: NewsResponse? = null

    init {
        getIndonesiaBreakingNews("id")
        getLuarNegeriBreakingNews("us")
    }

    fun getIndonesiaBreakingNews(countryCode: String) = viewModelScope.launch {
        indonesiaBreakingNews.postValue(Resource.Loading())
        val response = newsRepository.getIndonesiaBreakingNews(countryCode, indonesiaBreakingNewsPage)
        indonesiaBreakingNews.postValue(handleIndonesiaBreakingNewsResponse(response))
    }

    fun getLuarNegeriBreakingNews(countryCode: String) = viewModelScope.launch {
        internasionalBreakingNews.postValue(Resource.Loading())
        val response = newsRepository.getLuarNegeriBreakingNews(countryCode, internasionalBreakingNewsPage)
        internasionalBreakingNews.postValue(handleInternasionalBreakingNewsResponse(response))
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery, searchNewsPage)
        searchNews.postValue(handleSearchNewsResponse(response))
    }

    private fun handleIndonesiaBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
         if(response.isSuccessful) {
             response.body()?.let {resultResponse ->
                 indonesiaBreakingNewsPage++
                 if(indonesiaBreakingNewsResponse == null) {
                     indonesiaBreakingNewsResponse = resultResponse
                 } else {
                     val oldArticles = indonesiaBreakingNewsResponse?.articles
                     val newArticles = resultResponse.articles
                     oldArticles?.addAll(newArticles)
                 }
                 return Resource.Success(indonesiaBreakingNewsResponse ?: resultResponse)
             }
         }
        return Resource.Error(response.message())
    }

    private fun handleInternasionalBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                internasionalBreakingNewsPage++
                if(internasionalBreakingNewsResponse == null) {
                    internasionalBreakingNewsResponse = resultResponse
                } else {
                    val oldArticles = internasionalBreakingNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(internasionalBreakingNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                searchNewsPage++
                if(searchNewsResponse == null) {
                    searchNewsResponse = resultResponse
                } else {
                    val oldArticles = searchNewsResponse?.articles
                    val newArticles = resultResponse.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(searchNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.update(article)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }
}
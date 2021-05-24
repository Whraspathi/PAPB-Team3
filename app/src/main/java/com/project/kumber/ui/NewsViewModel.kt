package com.project.kumber.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.kumber.Resource
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

    val internasionalBreakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var internasionalBreakingNewsPage = 1

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1

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
                 return Resource.Success(resultResponse)
             }
         }
        return Resource.Error(response.message())
    }

    private fun handleInternasionalBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}
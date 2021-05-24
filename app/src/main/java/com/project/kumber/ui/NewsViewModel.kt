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

    init {
        getIndonesiaBreakingNews("id")
        getLuarNegeriBreakingNews("us")
    }

    fun getIndonesiaBreakingNews(countryCode: String) = viewModelScope.launch {
        indonesiaBreakingNews.postValue(Resource.Loading())
        val response1 = newsRepository.getIndonesiaBreakingNews(countryCode, indonesiaBreakingNewsPage)
        indonesiaBreakingNews.postValue(handleIndonesiaBreakingNewsResponse(response1))
    }

    fun getLuarNegeriBreakingNews(countryCode: String) = viewModelScope.launch {
        internasionalBreakingNews.postValue(Resource.Loading())
        val response2 = newsRepository.getLuarNegeriBreakingNews(countryCode, internasionalBreakingNewsPage)
        internasionalBreakingNews.postValue(handleInternasionalBreakingNewsResponse(response2))
    }

    private fun handleIndonesiaBreakingNewsResponse(response1: Response<NewsResponse>) : Resource<NewsResponse> {
         if(response1.isSuccessful) {
             response1.body()?.let {resultResponse ->
                 return Resource.Success(resultResponse)
             }
         }
        return Resource.Error(response1.message())
    }

    private fun handleInternasionalBreakingNewsResponse(response2: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response2.isSuccessful) {
            response2.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response2.message())
    }
}
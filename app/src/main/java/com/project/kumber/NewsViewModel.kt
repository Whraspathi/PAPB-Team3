package com.project.kumber

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.kumber.Resource
import com.project.kumber.model.NewsResponse
import com.project.kumber.ui.fragment.NewsFragment
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel (
    val newsRepository: NewsRepository
    ) : ViewModel()
{
    val indonesiaBreakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var indonesiaBreakingNewsPage = 1

//    init {
//        getIndonesiaBreakingNews("id")
//    }

    fun getIndonesiaBreakingNews(countryCode: String) = viewModelScope.launch {
        indonesiaBreakingNews.postValue(Resource.Loading())
        val response = newsRepository.getIndonesiaBreakingNews(countryCode, indonesiaBreakingNewsPage)
        indonesiaBreakingNews.postValue(handleIndonesiaBreakingNewsResponse(response))
    }

    private fun handleIndonesiaBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
         if(response.isSuccessful) {
             response.body()?.let {resultResponse ->
                 return Resource.Success(resultResponse)
             }
         }
        return Resource.Error(response.message())
    }
}
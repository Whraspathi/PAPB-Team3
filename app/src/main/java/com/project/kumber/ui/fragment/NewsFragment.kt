package com.project.kumber.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.mvvmnewsapp.adapters.NewsAdapter
import com.project.kumber.NewsViewModel
import com.project.kumber.R
import com.project.kumber.Resource
import com.project.kumber.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(R.layout.fragment_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "IndonesiaBreakingNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.indonesiaBreakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                }
            }
        })
     return view
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        news_recyclerview.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity, "This is the newest News", Toast.LENGTH_LONG).show()
    }
}

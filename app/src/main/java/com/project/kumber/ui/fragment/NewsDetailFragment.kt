package com.project.kumber.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.kumber.R
import com.project.kumber.ui.MainActivity
import com.project.kumber.ui.NewsViewModel

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}
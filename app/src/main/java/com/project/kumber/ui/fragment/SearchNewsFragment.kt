package com.project.kumber.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.project.kumber.R
import com.project.kumber.ui.MainActivity
import com.project.kumber.ui.NewsViewModel

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}
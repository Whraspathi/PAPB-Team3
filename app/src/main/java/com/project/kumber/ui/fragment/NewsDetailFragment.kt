package com.project.kumber.ui.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.project.kumber.R
import com.project.kumber.model.Article
import com.project.kumber.ui.MainActivity
import com.project.kumber.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news_detail.*

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    lateinit var viewModel: NewsViewModel
    val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url!!)
        }

        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view, "You've successfully saved a news!", Snackbar.LENGTH_SHORT).show()
        }
    }
}
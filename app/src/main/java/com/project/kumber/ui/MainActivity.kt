package com.project.kumber.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.project.kumber.repository.NewsRepository
import com.project.kumber.ui.fragment.HomeFragment
import com.project.kumber.R
import com.project.kumber.db.ArticleDatabase

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel  = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

        val homeFragment = HomeFragment();
    }
}
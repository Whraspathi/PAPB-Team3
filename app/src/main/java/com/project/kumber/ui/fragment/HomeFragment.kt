package com.project.kumber.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.project.kumber.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        v.button_idnNews.setOnClickListener { Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_indonesiaNewsFragment)}
        v.button_interNews.setOnClickListener { Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_internationalNewsFragment)}
        v.button_savedNews.setOnClickListener { Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_savedNewsFragment)}
        v.button_searchNews.setOnClickListener { Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_searchNewsFragment)}

        return v
    }
}
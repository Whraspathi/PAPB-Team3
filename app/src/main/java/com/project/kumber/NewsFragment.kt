package com.project.kumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class NewsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_news, container, false)
        val clickBtn1 = v.findViewById<View>(R.id.card_news1) as CardView
        val clickBtn2 = v.findViewById<View>(R.id.card_news2) as CardView

        clickBtn1.setOnClickListener{
            val frNewsDetail = fragmentManager!!.beginTransaction()
            frNewsDetail.replace(R.id.fragment_container, NewsDetailFragment())
            frNewsDetail.addToBackStack(null).commit()
        }
        clickBtn2.setOnClickListener{
            val frNewsDetail = fragmentManager!!.beginTransaction()
            frNewsDetail.replace(R.id.fragment_container, NewsDetailFragment())
            frNewsDetail.addToBackStack(null).commit()
        }

        return v
    }
}
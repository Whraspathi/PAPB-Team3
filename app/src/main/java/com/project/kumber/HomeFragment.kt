package com.project.kumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        val clickBtn1 = v.findViewById<View>(R.id.button1) as CardView
        val clickBtn2 = v.findViewById<View>(R.id.button2) as CardView
        val clickBtn3 = v.findViewById<View>(R.id.button3) as CardView
        val clickBtn4 = v.findViewById<View>(R.id.button4) as CardView

        clickBtn1.setOnClickListener{
            val frNews = fragmentManager!!.beginTransaction()
            frNews.replace(R.id.fragment_container, NewsFragment())
            frNews.addToBackStack(null).commit()
        }
        clickBtn2.setOnClickListener{
            val frNews = fragmentManager!!.beginTransaction()
            frNews.replace(R.id.fragment_container, NewsFragment())
            frNews.addToBackStack(null).commit()
        }
        clickBtn3.setOnClickListener{
            val frNews = fragmentManager!!.beginTransaction()
            frNews.replace(R.id.fragment_container, NewsFragment())
            frNews.addToBackStack(null).commit()
        }
        clickBtn4.setOnClickListener{
            val frNews = fragmentManager!!.beginTransaction()
            frNews.replace(R.id.fragment_container, NewsFragment())
            frNews.addToBackStack(null).commit()
        }

        return v
    }
}
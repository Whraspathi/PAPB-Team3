package com.project.kumber.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.kumber.ui.fragment.HomeFragment
import com.project.kumber.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

        val homeFragment = HomeFragment();
        //initialize fragmentmu

        //
        supportFragmentManager.beginTransaction().apply {

        }
    }
}
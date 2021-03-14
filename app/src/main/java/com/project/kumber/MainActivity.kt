package com.project.kumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment();
        //initialize fragmentmu

        //
        supportFragmentManager.beginTransaction().apply {

        }
    }
}
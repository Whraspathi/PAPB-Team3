package com.project.kumber

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.ContentView
import androidx.appcompat.app.AppCompatActivity

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
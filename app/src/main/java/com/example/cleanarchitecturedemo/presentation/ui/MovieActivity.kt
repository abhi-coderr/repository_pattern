package com.example.cleanarchitecturedemo.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var activityMovieBinding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)



    }
}
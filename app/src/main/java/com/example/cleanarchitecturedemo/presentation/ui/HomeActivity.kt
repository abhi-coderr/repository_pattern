package com.example.cleanarchitecturedemo.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.data.model.artist.Artist
import com.example.cleanarchitecturedemo.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        )

        activityMainBinding.artistBtn.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }

        activityMainBinding.movieBtn.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        activityMainBinding.tvShowBtn.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }

    }
}
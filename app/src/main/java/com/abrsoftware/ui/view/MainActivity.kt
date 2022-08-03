package com.abrsoftware.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.abrsoftware.newmovies.R
import com.abrsoftware.newmovies.databinding.ActivityMainBinding
import com.abrsoftware.ui.viewmodel.MovieViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val moviesViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moviesViewModel.onCreate()
        moviesViewModel.movieModel.observe(this, Observer {
            binding.title.text = it.title
            Log.d("MSJ", it.title)
        })

    }
}
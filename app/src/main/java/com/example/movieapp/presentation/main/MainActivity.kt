package com.example.movieapp.presentation.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.home.view.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}

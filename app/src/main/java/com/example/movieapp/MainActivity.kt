package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.movieapp.api.ApiService

class MainActivity : AppCompatActivity() {

    //prueba de usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenStarted {
            val discoverResponse = ApiService.service.discoverMovies()
            Log.i("discoverResponse", discoverResponse.results.toString())
        }
    }
}
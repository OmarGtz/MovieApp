package com.example.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.toMovieUrl

class MovieDetailFragment : Fragment() {
    
    lateinit var title: String
    lateinit var backdrop_path:String
    lateinit var poster_path:String
    lateinit var overview:String
    lateinit var release_date:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            title = bundle.getString("title").toString()
            backdrop_path = bundle.getString("backdrop_path").toString()
            poster_path = bundle.getString("poster_path").toString()
            overview = bundle.getString("overview").toString()
            release_date = bundle.getString("release_date").toString()
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_movil_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvTitle = view.findViewById<TextView>(R.id.title_detail_movie)
        val tvOverview = view.findViewById<TextView>(R.id.tv_overview)
        val ivBackdropPath = view.findViewById<ImageView>(R.id.iv_backdrop_path)
        val ivPosterPath = view.findViewById<ImageView>(R.id.iv_poster_path)
        val tvReleaseDate = view.findViewById<TextView>(R.id.tv_release_date)

        tvTitle.text = title
        tvOverview.text = overview
        tvReleaseDate.text = release_date
        Glide.with(requireContext())
            .load(backdrop_path?.toMovieUrl())
            .into(ivBackdropPath)
        Glide.with(requireContext())
            .load(poster_path.toMovieUrl())
            .into(ivPosterPath)
    }

}
package com.example.movieapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.api.ApiService
import com.example.movieapp.api.DiscoverResponse
import com.example.movieapp.api.Genre
import com.example.movieapp.api.MovieDetail
import com.example.movieapp.toMovieUrl

class MovieDetailFragment : Fragment() {

    private var id: Int? = 0

    lateinit var tvTitle:TextView
    lateinit var tvOverview:TextView
    lateinit var ivBackdropPath:ImageView
    lateinit var ivPosterPath:ImageView
    lateinit var tvReleaseDate:TextView
    lateinit var tvStatus:TextView
    lateinit var tvPorcentCount:TextView
    lateinit var tvVotesCount:TextView
    lateinit var tvRuntime:TextView

    lateinit var listGenre:List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            id = bundle.getInt("id")

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
        tvTitle = view.findViewById(R.id.title_detail_movie)
        tvOverview = view.findViewById(R.id.tv_overview)
        ivBackdropPath = view.findViewById(R.id.iv_backdrop_path)
        ivPosterPath = view.findViewById(R.id.iv_poster_path)
        tvReleaseDate = view.findViewById(R.id.tv_release_date)
        tvStatus = view.findViewById(R.id.tvStatus)
        tvPorcentCount = view.findViewById(R.id.tvPorcentCount)
        tvVotesCount = view.findViewById(R.id.tvVotesCount)
        tvRuntime = view.findViewById(R.id.tvRuntime)

        lifecycleScope.launchWhenCreated {
            var movieDetailData = ApiService.service.detailMovie(id!!)
            Log.d("TAG", "id:$id ")
            setDataMovie(movieDetailData)
        }
    }

    private fun setDataMovie(movieDetailData:MovieDetail){
        tvTitle.text = movieDetailData.title
        tvOverview.text = movieDetailData.overview
        tvReleaseDate.text = movieDetailData.release_date
        tvStatus.text = movieDetailData.status
        tvPorcentCount.text = "${movieDetailData.vote_average*10}"
        tvVotesCount.text = "${movieDetailData.vote_count}"
        tvRuntime.text = "${movieDetailData.runtime}m"

        Glide.with(requireContext())
           .load(movieDetailData.backdrop_path?.toMovieUrl())
            .into(ivBackdropPath)

        Glide.with(requireContext())
            .load(movieDetailData.poster_path?.toMovieUrl())
            .into(ivPosterPath)
    }

}
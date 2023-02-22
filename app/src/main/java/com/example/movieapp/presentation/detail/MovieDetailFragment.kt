package com.example.movieapp.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.utils.getViewModelFactory
import com.example.movieapp.utils.toMovieUrl

class MovieDetailFragment: Fragment() {
    private lateinit var id: String

    lateinit var tvTitle:TextView
    lateinit var tvOverview:TextView
    lateinit var ivBackdropPath: ImageView
    lateinit var ivPosterPath:ImageView
    lateinit var tvReleaseDate:TextView
    lateinit var tvStatus:TextView
    lateinit var tvPorcentCount:TextView
    lateinit var tvVotesCount:TextView
    lateinit var tvRuntime:TextView

    val viewModel: MovieDetailViewModel by viewModels {
        getViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            id = bundle.getString("id")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subscribeDetail()
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
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
        viewModel.getDetail(id)
    }

    fun subscribeDetail() {
        viewModel.detail.observe(viewLifecycleOwner) {

            tvTitle.text = it.title
            tvOverview.text = it.overview
            tvReleaseDate.text = it.release_date
            tvStatus.text = it.status
            tvPorcentCount.text = "${it.vote_average*10}"
            tvVotesCount.text = "${it.vote_count}"
            tvRuntime.text = "${it.runtime}m"

            Glide.with(requireContext())
                .load(it.backdrop_path?.toMovieUrl())
                .into(ivBackdropPath)

            Glide.with(requireContext())
                .load(it.poster_path?.toMovieUrl())
                .into(ivPosterPath)

            // TODO Init views

        }
    }

}
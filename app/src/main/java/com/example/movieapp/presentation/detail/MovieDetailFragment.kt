package com.example.movieapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.utils.toMovieUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: Fragment() {
    private lateinit var id: String

    var binding: FragmentMovieDetailBinding? = null

    val viewModel: MovieDetailViewModel by viewModels()

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
        binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)
        viewModel.getDetail(id)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    fun subscribeDetail() {
        viewModel.detail.observe(viewLifecycleOwner) {
            binding?.apply {
                titleDetailMovie.text = it.title
                tvOverview.text = it.overview
                tvReleaseDate.text = it.releaseDate
                tvPorcentCount.text = "${it.votesCount*10}"
                tvVotesCount.text = "${it.votesCount}"
                Glide.with(requireContext())
                    .load(it.backdropPath.toMovieUrl())
                    .into(ivBackdropPath)
                Glide.with(requireContext())
                    .load(it.posterPath.toMovieUrl())
                    .into(ivPosterPath)
            }
        }
    }

}
package com.example.movieapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.R
import com.example.movieapp.utils.getViewModelFactory

class MovieDetailFragment: Fragment() {

    val viewModel: MovieDetailViewModel by viewModels {
        getViewModelFactory()
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
        viewModel.getDetail("500")
        // TODO traer id del home
    }

    fun subscribeDetail() {
        viewModel.detail.observe(viewLifecycleOwner) {
            // TODO Init views
        }
    }

}
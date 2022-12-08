package com.example.movieapp.ui.fragments.movie_list_by_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.api.ApiService
import com.example.movieapp.ui.adapters.AllMoviesAdapter


class MovieListByCategoryFragment : Fragment() {

    private var imagesListCategoryMovies = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list_by_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            val movies = ApiService.service.discoverMovies()
            initRvCategoryMovies(movies.results)
        }
    }

    private fun addMovieToList(image: Int) {
        imagesListCategoryMovies.add(image)
    }

    private fun initRvCategoryMovies(list: List<com.example.movieapp.api.Result>) {
        val rvByCategoriesMovies = view?.findViewById<RecyclerView>(R.id.rvCategoryListMovies)
        rvByCategoriesMovies?.layoutManager = GridLayoutManager(context, 2)
        val adapter = AllMoviesAdapter(list) {
            findNavController().navigate(R.id.action_movieListByCategoryFragment_to_movieDetailFragment,
                bundleOf(
                    "title" to it.title,
                    "backdrop_path" to it.backdrop_path,
                    "poster_path" to it.poster_path,
                    "overview" to it.overview,
                    "release_date" to it.release_date))
        }
        rvByCategoriesMovies?.adapter = adapter
    }
}
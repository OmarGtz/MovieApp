package com.example.movieapp.presentation.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.presentation.home.viewmodel.HomeViewModel
import com.example.movieapp.utils.getViewModelFactory
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels {
        getViewModelFactory()
    }

    private val movieAdapter: AllMoviesAdapter = AllMoviesAdapter {
        findNavController().navigate(R.id.action_homeFragment_to_movieDetailFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subscribeMovies()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvCategoryMovies()
        viewModel.getMovies()
    }

    private fun initRvCategoryMovies(){
        val rvByCategoriesMovies = view?.findViewById<RecyclerView>(R.id.rvCategoryListMovies)
        rvByCategoriesMovies?.layoutManager = GridLayoutManager(context,2)
        rvByCategoriesMovies?.adapter = movieAdapter
    }

    private fun subscribeMovies() {
        viewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.submit(it)
        }
    }
}
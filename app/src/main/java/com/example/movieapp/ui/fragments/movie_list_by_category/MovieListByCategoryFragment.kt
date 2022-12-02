package com.example.movieapp.ui.fragments.movie_list_by_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
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
        postToList()
        initRvCategoryMovies()
    }

    private fun addMovieToList(image:Int){
        imagesListCategoryMovies.add(image)
    }

    private fun postToList(){
        for (i in 1..16){
            addMovieToList(R.drawable.movie_example)
        }
    }

    private fun initRvCategoryMovies(){
        val rvByCategoriesMovies = view?.findViewById<RecyclerView>(R.id.rvCategoryListMovies)
        rvByCategoriesMovies?.layoutManager = GridLayoutManager(context,2)
        val adapter = AllMoviesAdapter(imagesListCategoryMovies)
        rvByCategoriesMovies?.adapter = adapter

    }
}
package com.example.movieapp.presentation.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemMovieBinding
import com.example.movieapp.presentation.home.model.MovieUI

class AllMoviesAdapter(val onClickListener: (String) -> Unit) : RecyclerView.Adapter<AllMoviesAdapter.MovieHolder>() {

    private var movies: List<MovieUI> = mutableListOf()

    inner class MovieHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieUI, onClickListener: (String) -> Unit) {
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .into(binding.ivMovie)
            binding.ivMovie.setOnClickListener {
                onClickListener(movie.id)
            }
        }
    }

    fun submit(imageList: List<MovieUI>) {
        movies = imageList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieHolder(
            ItemMovieBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
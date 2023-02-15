package com.example.movieapp.presentation.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.presentation.home.model.MovieUI

class AllMoviesAdapter(val onClickListener: (String) -> Unit) : RecyclerView.Adapter<AllMoviesAdapter.MovieHolder>() {

    private var movies: List<MovieUI> = mutableListOf()

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.ivMovie)

        fun bind(movie: MovieUI, onClickListener: (String) -> Unit) {
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .into(itemImage)
            itemImage.setOnClickListener {
                onClickListener(" ")
            }
        }
    }

    fun submit(imageList: List<MovieUI>) {
        movies = imageList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position], onClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
package com.example.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.api.Result
import com.example.movieapp.toMovieUrl

class AllMoviesAdapter (private var imageList:List<Result>, val onClick: (Result) -> Unit):RecyclerView.Adapter<AllMoviesAdapter.MovieHolder>() {
    inner class MovieHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val itemImage: ImageView = itemView.findViewById(R.id.ivMovie)

        fun bind(item:Result, onClick: (Result) -> Unit) {
            itemView.setOnClickListener {
                onClick(item)
            }
            Glide.with(itemView.context)
                .load(item.poster_path.toMovieUrl())
                .into(itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list_by_category, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(imageList[position], onClick = onClick)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}
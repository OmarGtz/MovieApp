package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R

class AllMoviesAdapter (private var imageList:List<Int>):RecyclerView.Adapter<AllMoviesAdapter.MovieHolder>() {
    inner class MovieHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.ivMovie)

        init {
            itemImage.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "Item clicked #${position + 1}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list_by_category, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.itemImage.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}
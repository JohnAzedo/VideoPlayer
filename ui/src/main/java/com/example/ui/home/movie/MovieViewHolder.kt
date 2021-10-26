package com.example.ui.home.movie

import androidx.activity.ktx.R
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Movie

import com.example.ui.databinding.ItemMovieBinding

class MovieViewHolder(
    private val itemBiding: ItemMovieBinding,
) : RecyclerView.ViewHolder(itemBiding.root){
    fun bind(movie: Movie){
        with(itemBiding){
            ivMovie.setImageResource(com.example.ui.R.drawable.hp_thumbnail)
        }
    }
}

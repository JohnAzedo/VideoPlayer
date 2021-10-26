package com.example.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.model.Movie
import com.example.ui.databinding.ItemMovieBinding
import com.example.ui.adapters.viewholders.MovieViewHolder

class MovieAdapter: ListAdapter<Movie, MovieViewHolder>(MovieDiffCallback()){

    companion object {
        class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem.title == newItem.title
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val biding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(biding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
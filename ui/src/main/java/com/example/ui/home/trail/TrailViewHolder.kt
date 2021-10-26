package com.example.ui.home.trail

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Trail
import com.example.ui.databinding.ItemTrailBinding
import com.example.ui.home.movie.MovieAdapter

class TrailViewHolder(
    private val itemBiding: ItemTrailBinding,
    private val movieAdapter: MovieAdapter,
    private val linearLayoutManager: LinearLayoutManager) : RecyclerView.ViewHolder(itemBiding.root) {
    fun bind(trail: Trail){
        with(itemBiding){
            txtNameTrial.text = trail.title
            movieAdapter.submitList(trail.movies)
            rvMovie.apply {
                layoutManager=linearLayoutManager
                adapter = movieAdapter
            }
        }
    }
}

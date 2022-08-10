package com.example.home.presentation.adapters.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.home.databinding.ItemTrailBinding
import com.example.home.domain.entities.Trail
import com.example.videoplayer.features.adapters.MovieAdapter

class TrailViewHolder(
    private val itemBiding: ItemTrailBinding,
    private val movieAdapter: MovieAdapter
    ) : RecyclerView.ViewHolder(itemBiding.root) {
    fun bind(trail: Trail){
        with(itemBiding){
            txtNameTrial.text = trail.title
            movieAdapter.submitList(trail.movies)
            rvMovie.apply {
                layoutManager=LinearLayoutManager(itemBiding.root.context, RecyclerView.HORIZONTAL, false)
                adapter = movieAdapter
            }
        }
    }
}

package com.example.videoplayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.model.Trail
import com.example.ui.databinding.ItemTrailBinding
import com.example.videoplayer.adapters.viewholders.TrailViewHolder


class TrailAdapter: ListAdapter<Trail, TrailViewHolder>(BookDiffCallback()){

    companion object {
        class BookDiffCallback : DiffUtil.ItemCallback<Trail>() {
            override fun areItemsTheSame(oldItem: Trail, newItem: Trail) = oldItem.title == newItem.title
            override fun areContentsTheSame(oldItem: Trail, newItem: Trail) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
        val binding = ItemTrailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val movieAdapter = MovieAdapter()
        return TrailViewHolder(binding, movieAdapter)
    }

    override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
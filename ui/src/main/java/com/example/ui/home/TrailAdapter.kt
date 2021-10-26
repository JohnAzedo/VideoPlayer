package com.example.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.model.Trail
import com.example.ui.databinding.ItemTrailBinding


class TrailAdapter : ListAdapter<Trail, TrailViewHolder>(BookDiffCallback()){

    companion object {
        class BookDiffCallback : DiffUtil.ItemCallback<Trail>() {
            override fun areItemsTheSame(oldItem: Trail, newItem: Trail) = oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Trail, newItem: Trail) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
        val biding = ItemTrailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrailViewHolder(biding)
    }

    override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
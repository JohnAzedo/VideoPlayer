package com.example.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.model.Trail
import com.example.ui.databinding.ItemTrailBinding

class TrailViewHolder(private val itemBiding: ItemTrailBinding) : RecyclerView.ViewHolder(itemBiding.root) {
    fun bind(trail: Trail){
        with(itemBiding){
            txtNameTrial.text = trail.title
        }
    }
}

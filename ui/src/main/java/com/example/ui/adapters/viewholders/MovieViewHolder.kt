package com.example.ui.adapters.viewholders

import android.net.Uri
import android.util.Log
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.Movie
import com.example.ui.R
import com.example.ui.databinding.ItemMovieBinding

class MovieViewHolder(
    private val itemBiding: ItemMovieBinding,
) : RecyclerView.ViewHolder(itemBiding.root){
    fun bind(movie: Movie){
        with(itemBiding){
            val uri = Uri.parse(movie.imageUrl)
            Glide.with(itemBiding.root.context).load(uri).into(ivMovie)
            ivMovie.setOnClickListener {
//                Log.v("MovieViewHolder", "Has clicked: " + movie.title)
                navigateToNewFragment()
            }
        }
    }

    fun navigateToNewFragment(){
        itemBiding.root.findNavController().navigate(R.id.movie_detail_fragment)
    }
}

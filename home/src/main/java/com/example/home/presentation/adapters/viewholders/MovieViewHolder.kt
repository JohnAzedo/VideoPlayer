package com.example.home.presentation.adapters.viewholders

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView

import com.example.home.databinding.ItemMovieBinding
import com.example.home.domain.entities.Movie


class MovieViewHolder(
    private val itemBiding: ItemMovieBinding,
) : RecyclerView.ViewHolder(itemBiding.root){
    fun bind(movie: Movie){
        with(itemBiding){
            val uri = Uri.parse(movie.imageUrl)
//            Glide.with(itemBiding.root.context).load(uri).into(ivMovie)
            ivMovie.setOnClickListener {
//                navigateToNewFragment(movie)
            }
        }
    }

//    private fun navigateToNewFragment(movie: Movie){
//        val bundle = Bundle()
//        bundle.putInt("movieId", movie.id)
//        bundle.putString("movieTitle", movie.title)
//        itemBiding.root.findNavController().navigate(R.id.movie_detail_fragment, bundle)
//    }
}

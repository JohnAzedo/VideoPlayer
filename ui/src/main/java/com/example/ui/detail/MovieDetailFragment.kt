package com.example.ui.detail

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ui.databinding.MovieDetailFragmentBinding
import com.example.ui.detail.MovieDetailViewModelFactory.make

class MovieDetailFragment: Fragment(){

    private val viewModel: MovieDetailViewModel by lazy { make() }
    private var bind: MovieDetailFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = MovieDetailFragmentBinding.inflate(inflater, container, false)
        arguments?.let {
            val id = it.getInt("movieId")
            viewModel.getMovie(id)
        }
        return bind?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.movie.observe(viewLifecycleOwner) { movie ->
            with(bind!!) {
                txtMovieTitle.text = movie.title
                txtMovieDescription.text = movie.description
                txtMovieGenres.text = "Ação"
                val uri = Uri.parse(movie.imageUrl)
                Glide.with(root.context).load(uri).into(ivMovie)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }

}
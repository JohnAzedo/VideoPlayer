package com.example.videoplayer.features.detail

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.videoplayer.R
import com.example.videoplayer.databinding.MovieDetailFragmentBinding
import com.example.videoplayer.features.detail.adapters.CustomFragmentStateAdapter
import com.example.videoplayer.features.detail.listeners.CustomTabLayoutClickListener
import org.koin.android.ext.android.inject

class MovieDetailFragment: Fragment(){

    private val viewModel: MovieDetailViewModel by inject()
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
        observeMovieState()
        setTabs()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeMovieState() {
        viewModel.movie.observe(viewLifecycleOwner) { movie ->
            with(bind!!) {
                txtMovieTitle.text = movie.title
                txtMovieDescription.text = movie.description
                txtMovieGenres.text = "Ação"
                val uri = Uri.parse(movie.imageUrl)
                Glide.with(root.context).load(uri).into(ivMovie)
            }
        }
    }

    private fun setTabs() {
        val fm = requireActivity().supportFragmentManager
        val adapter = CustomFragmentStateAdapter(fm, lifecycle)
        bind?.let {
            it.pager.adapter = adapter
            it.tabLayout.addTab(it.tabLayout.newTab().setText(R.string.watch_too))
            it.tabLayout.addTab(it.tabLayout.newTab().setText(R.string.info_detail))
            it.tabLayout.addOnTabSelectedListener(CustomTabLayoutClickListener(it.pager))
        }
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }

}
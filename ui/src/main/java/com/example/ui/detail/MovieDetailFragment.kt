package com.example.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return bind?.root
    }


    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }

}
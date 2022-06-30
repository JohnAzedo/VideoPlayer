package com.example.videoplayer.features.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.videoplayer.databinding.MyListFragmentBinding
import com.example.videoplayer.features.adapters.MovieAdapter
import org.koin.android.ext.android.inject

class MyListFragment: Fragment(){
    private var bind: MyListFragmentBinding? = null
    private val viewModel: MyListViewModel by inject()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = MyListFragmentBinding.inflate(inflater, container, false)
        viewModel.getMovies()
        movieAdapter = MovieAdapter()
        return bind?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.observe(viewLifecycleOwner) {
            movieAdapter.submitList(it.value)
        }

        viewModel.actions.observe(viewLifecycleOwner) {}

        bind?.let {
            it.rvMovie.apply {
                layoutManager = GridLayoutManager(activity, 3)
                adapter = movieAdapter
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}
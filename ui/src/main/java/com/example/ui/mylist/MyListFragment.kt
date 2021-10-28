package com.example.ui.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ui.databinding.MyListFragmentBinding
import com.example.ui.adapters.MovieAdapter
import com.example.ui.mylist.MyListViewModelFactory.make

class MyListFragment: Fragment(){
    private var bind: MyListFragmentBinding? = null
    private val viewModel: MyListViewModel by lazy { make() }
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
        viewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.submitList(it)
        }

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
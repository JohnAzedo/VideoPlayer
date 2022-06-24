package com.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui.databinding.HomeFragmentBinding
import com.example.ui.home.HomeViewModelFactory.make
import com.example.ui.adapters.TrailAdapter

class HomeFragment: Fragment() {

    private var bind: HomeFragmentBinding? = null
    private val viewModel: HomeViewModel by lazy { make() }
    private lateinit var trailAdapter: TrailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = HomeFragmentBinding.inflate(inflater, container, false)
        trailAdapter = TrailAdapter()
        viewModel.getTrails()
        return bind?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.observe(viewLifecycleOwner) {
            trailAdapter.submitList(it.value)
            showTrails()
        }

        viewModel.actions.observe(viewLifecycleOwner) {
            when(it){
                HomeAction.HideLoader -> hideLoader()
            }
        }

        bind?.let {
            it.rvTrail.apply { 
                layoutManager = LinearLayoutManager(activity)
                adapter = trailAdapter
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun hideLoader() {
        bind?.loader?.visibility = View.GONE
    }

    private fun showTrails(){
        bind?.rvTrail?.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}
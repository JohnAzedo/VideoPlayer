package com.example.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.commons.view.TagLayout
import com.example.commons.view.onStateChange
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.presentation.adapters.TrailAdapter
import org.koin.android.ext.android.inject

class HomeFragment: Fragment(), TagLayout {

    private var _bind: HomeFragmentBinding? = null
    private val bind get() = _bind!!

    private val viewModel: HomeViewModel by inject()
    private lateinit var trailAdapter: TrailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = HomeFragmentBinding.inflate(inflater, container, false)
        trailAdapter = TrailAdapter()
        return _bind?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bind.rvTrail.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = trailAdapter
        }
        handleState()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun handleState() = onStateChange(viewModel) {
        handleVisibility(it.tag)
        trailAdapter.submitList(it.trails)
    }

    override fun onDestroy() {
        _bind = null
        super.onDestroy()
    }

    override var containerLayout: View = bind.rvTrail
    override var errorLayout: View = bind.error
    override var loaderLayout: View = bind.loader
}
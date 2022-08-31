package com.example.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tools.view.Layout
import com.example.tools.view.handleVisibility
import com.example.tools.view.onStateChange
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.presentation.adapters.TrailAdapter
import org.koin.android.ext.android.inject

class HomeFragment: Fragment() {
    private var _bind: HomeFragmentBinding? = null
    private val bind get() = _bind!!

    private lateinit var layout: Layout

    private val viewModel: HomeViewModel by inject()
    private lateinit var trailAdapter: TrailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bind = HomeFragmentBinding.inflate(inflater, container, false)
        layout = Layout(container = bind.rvTrail, error = bind.txtError, loader = bind.loader)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        trailAdapter = TrailAdapter()
        bind.rvTrail.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = trailAdapter
        }
        handleState()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun handleState() = onStateChange(viewModel) {
        trailAdapter.submitList(it.trails)
        handleVisibility(it.tag, layout)
    }

    override fun onDestroy() {
        _bind = null
        super.onDestroy()
    }
}
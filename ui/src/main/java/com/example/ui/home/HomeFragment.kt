package com.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ui.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private var bind: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = HomeFragmentBinding.inflate(inflater, container, false)
        return bind?.root
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }

}
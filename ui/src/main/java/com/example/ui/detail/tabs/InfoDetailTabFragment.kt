package com.example.ui.detail.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ui.databinding.TabDetailFragmentBinding

class InfoDetailTabFragment: Fragment(){

    private var bind: TabDetailFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = TabDetailFragmentBinding.inflate(inflater, container, false)
        return bind?.root
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}
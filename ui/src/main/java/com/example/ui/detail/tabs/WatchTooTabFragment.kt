package com.example.ui.detail.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ui.databinding.TabWatchTooFragmentBinding

class WatchTooTabFragment: Fragment(){

    private var bind: TabWatchTooFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind = TabWatchTooFragmentBinding.inflate(inflater, container, false)
        return bind?.root
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}
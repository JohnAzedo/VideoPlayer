package com.example.videoplayer.features.detail.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.videoplayer.features.detail.tabs.InfoDetailTabFragment
import com.example.videoplayer.features.detail.tabs.WatchTooTabFragment

class CustomFragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUMBER_OF_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WatchTooTabFragment()
            1 -> InfoDetailTabFragment()
            else -> Fragment()
        }
    }

    companion object {
        const val NUMBER_OF_TABS = 2
    }

}
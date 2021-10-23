package com.example.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mylist.databinding.MyListFragmentBinding

class MyListFragment: Fragment(){
    private var bind: MyListFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = MyListFragmentBinding.inflate(inflater, container, false)
        return bind?.root
    }

    override fun onDestroy() {
        bind = null
        super.onDestroy()
    }
}
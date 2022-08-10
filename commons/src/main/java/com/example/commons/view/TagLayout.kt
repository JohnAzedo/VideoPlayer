package com.example.commons.view

import android.view.View
import com.example.commons.viewmodel.Tag

interface TagLayout {
    var containerLayout: View
    var errorLayout: View
    var loaderLayout: View

    fun handleVisibility(tag: Tag){
        containerLayout.visibility = View.GONE
        errorLayout.visibility = View.GONE
        loaderLayout.visibility = View.GONE

        when(tag) {
            Tag.SUCCESS -> containerLayout.visibility = View.VISIBLE
            Tag.LOADING -> loaderLayout.visibility = View.VISIBLE
            Tag.FAILURE -> errorLayout.visibility = View.VISIBLE
        }
    }
}

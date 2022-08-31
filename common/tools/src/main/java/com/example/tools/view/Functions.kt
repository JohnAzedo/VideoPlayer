package com.example.tools.view

import android.view.View
import com.example.tools.viewmodel.Action
import com.example.tools.viewmodel.State
import com.example.tools.viewmodel.ViewModel
import androidx.fragment.app.Fragment
import com.example.tools.viewmodel.Tag


inline fun <S: State, A: Action> Fragment.onStateChange(
    viewModel: ViewModel<S, A>,
    crossinline handleState: (S) -> Unit
) {
    viewModel.state.observe(viewLifecycleOwner) { state ->
        handleState(state)
    }
}

fun View.changeVisibility(){
    this.visibility = when(this.visibility){
        View.GONE -> View.VISIBLE
        View.VISIBLE -> View.GONE
        else -> View.GONE
    }
}

fun Fragment.handleVisibility(tag: Tag, layout: Layout){
    with(layout){
        container.visibility = View.GONE
        error.visibility = View.GONE
        loader.visibility = View.GONE
    }

    when(tag) {
        Tag.SUCCESS -> layout.container.changeVisibility()
        Tag.LOADING -> layout.loader.changeVisibility()
        Tag.FAILURE -> layout.error.changeVisibility()
    }
}

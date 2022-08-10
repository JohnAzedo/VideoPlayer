package com.example.commons.view

import android.view.View
import com.example.commons.viewmodel.Action
import com.example.commons.viewmodel.State
import com.example.commons.viewmodel.ViewModel
import androidx.fragment.app.Fragment


inline fun <S: State, A:Action> Fragment.onStateChange(
    viewModel: ViewModel<S, A>,
    crossinline handleState: (S) -> Unit
) {
    viewModel.state.observe(viewLifecycleOwner) { state ->
        handleState(state)
    }
}

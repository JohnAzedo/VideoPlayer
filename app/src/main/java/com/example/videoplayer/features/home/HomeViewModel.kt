package com.example.videoplayer.features.home

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetTrailsUseCase
import com.example.videoplayer.generics.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val trailUseCase: GetTrailsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel<HomeState, HomeAction>() {

    fun getTrails() {
        viewModelScope.launch(dispatcher) {
            val trails = trailUseCase.getTrails()
            setState(HomeState(trails))
            setAction(HomeAction.HideLoader)
        }
    }
}
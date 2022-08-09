package com.example.home.presentation

import com.example.commons.viewmodel.ViewModel
import com.example.home.domain.entities.Trail
import com.example.home.domain.usecases.GetTrailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


@FlowPreview
class HomeViewModel(
    private val useCase: GetTrailUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel<HomeState, HomeAction>(HomeState.EMPTY_VALUE) {

    init {
        viewModelScope.launch {
            useCase()
                .flowOn(dispatcher)
                .catch { onCatch(it) }
                .collect(::onCollectTrails)
        }
    }

    private fun onCollectTrails(trails: List<Trail>){
        val state = HomeState(trails)
        setState(state)
    }

    private fun onCatch(throwable: Throwable) {

    }

}
package com.example.home.presentation

import com.example.commons.viewmodel.ViewModel
import com.example.home.domain.entities.Trail
import com.example.home.domain.usecases.GetTrailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import androidx.lifecycle.viewModelScope
import com.example.commons.viewmodel.Tag
import kotlinx.coroutines.launch


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
        setState { HomeState(trails, Tag.SUCCESS) }
    }

    private fun onCatch(throwable: Throwable) {
        setState { HomeState(listOf(), Tag.FAILURE) }
    }
}
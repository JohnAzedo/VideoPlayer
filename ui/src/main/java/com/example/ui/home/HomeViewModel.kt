package com.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetTrailsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
    private val trailUseCase: GetTrailsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState> get() = _state

    private val _actions = MutableLiveData<HomeAction>()
    val actions: LiveData<HomeAction> get() = _actions

    fun getTrails() {
        viewModelScope.launch(dispatcher) {
            val trails = trailUseCase.getTrails()
            _state.postValue(HomeState(trails))
            _actions.postValue(HomeAction.HideLoader)
        }
    }
}
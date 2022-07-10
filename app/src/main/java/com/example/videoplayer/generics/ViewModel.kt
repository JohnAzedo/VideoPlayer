package com.example.videoplayer.generics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


open class ViewModel<UIState: State, UIAction: Action>(
    initialState: UIState
): androidx.lifecycle.ViewModel() {

    private val _state = MutableLiveData<UIState>()
    val state: LiveData<UIState> get() = _state

    private val _actions = MutableLiveData<UIAction>()
    val actions: LiveData<UIAction> get() = _actions

    protected fun setState(currentState: UIState){
        _state.postValue(currentState)
    }

    protected fun setAction(currentAction: UIAction){
        _actions.postValue(currentAction)
    }

    init {
        _state.postValue(initialState)
    }
}
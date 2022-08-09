package com.example.commons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


abstract class ViewModel<UIState: State, UIAction: Action>(
    initialState: UIState
): androidx.lifecycle.ViewModel() {

    private val _state = MutableLiveData(initialState)
    val state: LiveData<UIState> get() = _state

    private val _actions = MutableLiveData<UIAction>()
    val actions: LiveData<UIAction> get() = _actions

    protected fun setState(currentState: UIState){
        _state.postValue(currentState)
    }

    protected fun setAction(currentAction: UIAction){
        _actions.postValue(currentAction)
    }
}
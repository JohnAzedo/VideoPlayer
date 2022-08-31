package com.example.tools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


abstract class ViewModel<S: State, A: Action>(
    initialState: S
): androidx.lifecycle.ViewModel() {

    private val _state = MutableLiveData(initialState)
    val state: LiveData<S> get() = _state

    private val _actions = MutableLiveData<A>()
    val actions: LiveData<A> get() = _actions

    protected fun setState(currentState: () -> S){
        _state.value = currentState()
    }

    protected fun setAction(currentAction: A){
        _actions.postValue(currentAction)
    }
}
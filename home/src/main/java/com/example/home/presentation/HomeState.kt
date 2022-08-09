package com.example.home.presentation

import com.example.commons.viewmodel.State
import com.example.home.domain.entities.Trail


data class HomeState(
    var value: List<Trail>,
) : State {

    companion object {
        val EMPTY_VALUE = HomeState(listOf())
    }
}

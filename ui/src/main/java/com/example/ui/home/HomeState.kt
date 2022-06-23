package com.example.ui.home

import com.example.model.Trail
import com.example.ui.ViewState

data class HomeState (
    val value: List<Trail>
): ViewState()

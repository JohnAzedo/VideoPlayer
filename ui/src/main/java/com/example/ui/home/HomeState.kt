package com.example.ui.home

import com.example.model.Trail
import com.example.ui.State

data class HomeState (
    var value: List<Trail>,
): State

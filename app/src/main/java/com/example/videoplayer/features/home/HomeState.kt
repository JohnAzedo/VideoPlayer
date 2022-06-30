package com.example.videoplayer.features.home

import com.example.model.Trail
import com.example.videoplayer.generics.State

data class HomeState (
    var value: List<Trail>,
): State

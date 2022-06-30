package com.example.videoplayer.home

import com.example.model.Trail
import com.example.videoplayer.State

data class HomeState (
    var value: List<Trail>,
): State

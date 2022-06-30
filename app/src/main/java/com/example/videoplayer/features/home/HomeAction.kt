package com.example.videoplayer.features.home

import com.example.videoplayer.generics.Action

sealed interface HomeAction: Action {
    object HideLoader: HomeAction
}
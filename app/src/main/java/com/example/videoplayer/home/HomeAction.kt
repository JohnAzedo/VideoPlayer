package com.example.videoplayer.home

import com.example.videoplayer.Action

sealed interface HomeAction: Action {
    object HideLoader: HomeAction
}
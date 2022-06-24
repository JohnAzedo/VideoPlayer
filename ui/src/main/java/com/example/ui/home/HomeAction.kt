package com.example.ui.home

import com.example.ui.Action

sealed interface HomeAction: Action {
    object HideLoader: HomeAction
}
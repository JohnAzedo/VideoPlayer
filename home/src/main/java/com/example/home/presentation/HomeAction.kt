package com.example.home.presentation

import com.example.commons.viewmodel.Action

sealed interface HomeAction: Action {
    object HideLoader: HomeAction
}
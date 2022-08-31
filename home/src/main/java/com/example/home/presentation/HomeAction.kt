package com.example.home.presentation

import com.example.tools.viewmodel.Action

sealed interface HomeAction: Action {
    object DisplayError: HomeAction
}
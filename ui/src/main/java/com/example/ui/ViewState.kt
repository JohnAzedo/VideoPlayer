package com.example.ui

abstract class ViewState {
    var status: ViewStatus = ViewStatus.LOADING
}

enum class ViewStatus {
    LOADING, SUCCESS, FAILURE
}
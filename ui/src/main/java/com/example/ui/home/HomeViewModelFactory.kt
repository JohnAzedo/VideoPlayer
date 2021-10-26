package com.example.ui.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetTrailsUseCaseImpl
import com.example.domain.usecases.GetMovieUseCaseImpl

object HomeViewModelFactory {

    private class Factory: ViewModelProvider.Factory {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            val trailUseCase = GetTrailsUseCaseImpl()
            val movieUseCase = GetMovieUseCaseImpl()
            return HomeViewModel(trailUseCase, movieUseCase) as T
        }
    }

    fun Fragment.make(): HomeViewModel {
        return ViewModelProvider(this, Factory()).get(HomeViewModel::class.java)
    }
}
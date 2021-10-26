package com.example.ui.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.usecases.TrailUseCaseImpl

object HomeViewModelFactory {

    private class Factory: ViewModelProvider.Factory {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            val service =  RetrofitClient.buildService(MovieService::class.java)
//            val repository = MovieRepositoryImpl(service)
            val useCase = TrailUseCaseImpl()
            return HomeViewModel(useCase) as T
        }
    }

    fun Fragment.make(): HomeViewModel {
        return ViewModelProvider(this, Factory()).get(HomeViewModel::class.java)
    }
}
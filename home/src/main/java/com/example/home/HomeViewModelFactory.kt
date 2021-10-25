package com.example.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepository
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService

object HomeViewModelFactory {

    private class Factory: ViewModelProvider.Factory {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            val service =  RetrofitClient.buildService(MovieService::class.java)
            val repository = MovieRepositoryImpl(service)
            return HomeViewModel(repository) as T
        }
    }

    fun Fragment.make(): HomeViewModel {
        return ViewModelProvider(this, Factory()).get(HomeViewModel::class.java)
    }
}
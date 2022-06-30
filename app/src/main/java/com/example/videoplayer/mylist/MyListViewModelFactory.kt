package com.example.videoplayer.mylist

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.usecases.GetMovieUseCaseImpl


//object MyListViewModelFactory {
//    private class Factory: ViewModelProvider.Factory {
//        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
//            val service = RetrofitClient.buildService(MovieService::class.java)
//            val movieRepo = MovieRepositoryImpl(service)
//            val movieUseCase = GetMovieUseCaseImpl(movieRepo)
//            return MyListViewModel(movieUseCase) as T
//        }
//    }
//
//    fun Fragment.make(): MyListViewModel {
//        return ViewModelProvider(this, Factory()).get(MyListViewModel::class.java)
//    }
//}


package com.example.videoplayer.detail

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.usecases.GetMovieUseCaseImpl


//object MovieDetailViewModelFactory {
//    private class Factory: ViewModelProvider.Factory {
//        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
//            val service = RetrofitClient.buildService(MovieService::class.java)
//            val movieRepo = MovieRepositoryImpl(service)
//            val movieUseCase = GetMovieUseCaseImpl(movieRepo)
//            return MovieDetailViewModel(movieUseCase) as T
//        }
//    }
//
//    fun Fragment.make(): MovieDetailViewModel {
//        return ViewModelProvider(this, Factory()).get(MovieDetailViewModel::class.java)
//    }
//}

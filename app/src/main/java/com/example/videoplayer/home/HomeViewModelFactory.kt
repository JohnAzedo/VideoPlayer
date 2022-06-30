package com.example.videoplayer.home

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepository
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.usecases.GetTrailsUseCaseImpl
import com.example.domain.usecases.GetMovieUseCaseImpl
import kotlinx.coroutines.Dispatchers

//object HomeViewModelFactory {
//
//    private class Factory: ViewModelProvider.Factory {
//        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
//            val service = RetrofitClient.buildService(MovieService::class.java)
//            val movieRepo = MovieRepositoryImpl(service)
//            val trailUseCase = GetTrailsUseCaseImpl(movieRepo)
//            return HomeViewModel(trailUseCase) as T
//        }
//    }
//
//    class TestFactory(private val viewModel: HomeViewModel): ViewModelProvider.Factory {
//        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
//            return viewModel as T
//        }
//    }
//
//    fun Fragment.make(): HomeViewModel {
//        return ViewModelProvider(this, Factory()).get(HomeViewModel::class.java)
//    }
//}
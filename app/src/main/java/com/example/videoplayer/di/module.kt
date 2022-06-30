package com.example.videoplayer.di

import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepository
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.usecases.GetMovieUseCase
import com.example.domain.usecases.GetMovieUseCaseImpl
import com.example.domain.usecases.GetTrailsUseCase
import com.example.domain.usecases.GetTrailsUseCaseImpl
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module
import com.example.ui.home.HomeViewModel
import com.example.ui.mylist.MyListViewModel

val appModule = module {
    single {
        Dispatchers.IO
    }
    factoryOf(::MovieRepositoryImpl) { bind<MovieRepository>() }

    single {
        RetrofitClient.buildService(MovieService::class.java)
    }

    factoryOf(::GetTrailsUseCaseImpl) { bind<GetTrailsUseCase>() }
    factoryOf(::GetMovieUseCaseImpl) { bind<GetMovieUseCase>() }

    viewModelOf(::HomeViewModel)
    viewModelOf(::MyListViewModel)
}

package com.example.home.di

import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module
import com.example.home.presentation.HomeViewModel
import com.example.home.data.MovieRepositoryImpl
import com.example.home.domain.repositories.MovieRepository
import com.example.home.domain.usecases.GetTrailUseCase


val homeModule = module {
    single {
        Dispatchers.IO
    }

    factoryOf(::MovieRepositoryImpl){ bind<MovieRepository>() }
    viewModelOf(::HomeViewModel)
}
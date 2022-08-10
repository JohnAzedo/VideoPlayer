package com.example.home.data

import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl: MovieRepository {
    override fun getTrails(): Flow<List<Trail>> {
        return flow {
            emit(listOf())
        }
    }
}
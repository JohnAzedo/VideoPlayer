package com.example.home.data

import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.sql.Time
import java.time.Duration

class MovieRepositoryImpl: MovieRepository {
    override fun getTrails(): Flow<List<Trail>> {
        return flow {
            throw Throwable("Error")
        }
    }
}
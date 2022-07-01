package com.example.domain.usecases

import com.example.domain.entities.Trail
import com.example.domain.repositories.MovieRepository


class GetTrailsUseCaseImpl(
    private val movieRepository: MovieRepository
): GetTrailsUseCase{
    override suspend fun getTrails(): List<Trail> {
         val trails = listOf(
            Trail(id=28, title="Action"),
            Trail(id=12, title="Adventure"),
            Trail(id=16, title="Animation"),
            Trail(id=35, title="Comedy"),
            Trail(id=80, title="Crime"),
            Trail(id=99, title="Documentary"),
        )

        trails.map {
            it.movies = movieRepository.getMoviesByGenres(it.id)
        }

        return trails
    }
}

interface GetTrailsUseCase {
    suspend fun getTrails(): List<Trail>
}
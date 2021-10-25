package com.example.domain.usecases

import com.example.data.repositories.MovieRepository
import com.example.model.Movie

class MovieUseCaseImpl(
    private val movieRepository: MovieRepository
): MovieUseCase{
    override suspend fun getMovies(genresId: Int): List<Movie> {
        return movieRepository.getMoviesByGenres(genresId)
    }
}

interface MovieUseCase {
    suspend fun getMovies(genresId: Int): List<Movie>
}
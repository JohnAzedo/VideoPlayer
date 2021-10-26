package com.example.domain.usecases

import com.example.data.repositories.MovieRepository
import com.example.model.Movie

class GetMovieUseCaseImpl(
//    private val movieRepository: MovieRepository
): GetMovieUseCase{
//    override suspend fun getMovies(genresId: Int): List<Movie> {
//        return movieRepository.getMoviesByGenres(genresId)
//    }

    override suspend fun getMoviesMock(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "Testing 1",
                description = "Testing 1",
                imageUrl = ""
            ),
            Movie(
                id = 1,
                title = "Testing 2",
                description = "Testing 2",
                imageUrl = ""
            ),
            Movie(
                id = 1,
                title = "Testing 3",
                description = "Testing 3",
                imageUrl = ""
            )
        )
    }
}

interface GetMovieUseCase {
//    suspend fun getMovies(genresId: Int): List<Movie>
    suspend fun getMoviesMock(): List<Movie>
}
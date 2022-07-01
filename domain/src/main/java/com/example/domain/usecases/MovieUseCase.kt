package com.example.domain.usecases

import com.example.domain.entities.Movie
import com.example.domain.repositories.MovieRepository


class GetMovieUseCaseImpl(
    private val movieRepository: MovieRepository
): GetMovieUseCase{
    override suspend fun getMovie(movieId: Int): Movie {
        return movieRepository.getMovie(movieId)
    }

    override suspend fun getMoviesMock(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "Testing 1",
                description = "Testing 1",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 2,
                title = "Testing 2",
                description = "Testing 2",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 3,
                title = "Testing 3",
                description = "Testing 3",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 4,
                title = "Testing 4",
                description = "Testing 4",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 5,
                title = "Testing 5",
                description = "Testing 5",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            )
        )
    }
}

interface GetMovieUseCase {
    suspend fun getMovie(movieId: Int): Movie
    suspend fun getMoviesMock(): List<Movie>
}
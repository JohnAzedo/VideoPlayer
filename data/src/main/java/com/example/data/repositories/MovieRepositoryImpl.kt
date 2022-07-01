package com.example.data.repositories

import com.example.data.config.Output
import com.example.data.config.parseResponse
import com.example.data.response.MovieResponse
import com.example.data.response.toMovie
import com.example.data.services.MovieService
import com.example.domain.entities.Movie
import com.example.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val service: MovieService
): MovieRepository {
    override suspend fun getMovie(movieId: Int): Movie {
        val result = service.getMovie(movieId).parseResponse()

        when (result) {
            is Output.Success -> {
                val movie: MovieResponse = result.value
                return movie.toMovie()
            }
            is Output.Failure -> throw Exception()
        }
    }

    override suspend fun getMoviesByGenres(genresId: Int): List<Movie> {
        val result = service.discoveryMoviesByGenres(genresId).parseResponse()

        when (result) {
            is Output.Success -> {
                val movies: List<MovieResponse> = result.value.movies
                return movies.map {
                    it.toMovie()
                }
            }
            is Output.Failure -> throw Exception()
        }
    }
}

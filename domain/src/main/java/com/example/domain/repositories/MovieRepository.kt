package com.example.domain.repositories

import com.example.domain.entities.Movie


interface MovieRepository {
    suspend fun getMovie(movieId: Int) : Movie
    suspend fun getMoviesByGenres(genresId: Int): List<Movie>
}

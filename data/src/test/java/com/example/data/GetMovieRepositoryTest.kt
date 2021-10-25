package com.example.data

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetMovieRepositoryTest {
    @Test
    fun testGetMovies() = runBlocking {
        val repository = MovieRepositoryImpl(service)
        val movies = repository.getMoviesByGenres(GENRES_ID)
        Assert.assertEquals(20, movies.size)
    }

    companion object {
        const val GENRES_ID = 28
        val service = RetrofitClient.buildService(MovieService::class.java)
    }
}
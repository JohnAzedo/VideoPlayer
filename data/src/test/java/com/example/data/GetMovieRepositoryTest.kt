package com.example.data

import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
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
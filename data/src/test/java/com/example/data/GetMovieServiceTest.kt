package com.example.data

import com.example.data.config.RetrofitClient
import com.example.data.response.MovieListResponse
import com.example.data.response.MovieResponse
import com.example.data.services.MovieService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class GetMovieServiceTest {

    @Test
    fun testGetMovie() = runBlocking {
        val response: Response<MovieResponse> = service.getMovie(MOVIE_ID)
        assertEquals(response.isSuccessful, true)
    }

    @Test
    fun testGetListMovie() = runBlocking {
        val response: Response<MovieListResponse> = service.discoveryMoviesByGenres(GENRES_ID)
        assertEquals(response.isSuccessful, true)
    }


    companion object {
        const val MOVIE_ID = 550
        const val GENRES_ID = 28
        val service = RetrofitClient.buildService(MovieService::class.java)
    }
}
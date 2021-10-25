package com.example.data

import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call

class GetMovieTest {

    @Test
    fun getMovieTest() {
        val call: Call<MovieResponse> = service.getMovie(MOVIE_ID)
        val response = call.execute()
        assertEquals(response.isSuccessful, true)
    }

    @Test
    fun getMoviesTest() {
        val call: Call<MovieListResponse> = service.discoveryMoviesByGenres(GENRES_ID)
        val response = call.execute()
        assertEquals(response.isSuccessful, true)
    }

    companion object {
        const val MOVIE_ID = 550
        const val GENRES_ID = 28
        val service = RetrofitClient.buildService(MovieService::class.java)
    }
}
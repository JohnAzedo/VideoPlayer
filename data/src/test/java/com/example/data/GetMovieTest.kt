package com.example.data

import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call

class GetMovieTest {

    @Test
    fun getMoviesTest() {
        val service = RetrofitClient.buildService(MovieService::class.java)
        val call: Call<Movie> = service.getMovie(MOVIE_ID)
        val response = call.execute()
        assertEquals(response.isSuccessful, true)
    }

    companion object {
        const val MOVIE_ID = 550
    }
}
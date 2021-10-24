package com.example.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") movieId: Int): Call<Movie>
}
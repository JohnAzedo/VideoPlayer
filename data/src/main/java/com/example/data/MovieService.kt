package com.example.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/{movie_id}")
    fun getMovie(@Path("movie_id") movieId: Int): Call<MovieResponse>

    @GET("discover/movie")
    fun discoveryMoviesByGenres(@Query("with_genres") genresId: Int): Call<MovieListResponse>
}
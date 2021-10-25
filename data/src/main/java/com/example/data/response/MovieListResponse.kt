package com.example.data.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("results")
    val movies: List<MovieResponse>
)
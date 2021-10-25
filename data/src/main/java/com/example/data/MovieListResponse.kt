package com.example.data

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("result")
    val movies: List<MovieResponse>
)
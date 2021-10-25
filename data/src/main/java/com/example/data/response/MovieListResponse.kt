package com.example.data.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("result")
    val movies: List<MovieResponse>
)
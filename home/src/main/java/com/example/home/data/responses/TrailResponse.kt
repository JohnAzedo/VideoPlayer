package com.example.home.data.responses

import com.example.home.domain.entities.Movie
import com.google.gson.annotations.SerializedName

data class TrailResponse (
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("movies")
    var movies: List<MovieResponse>? = listOf()
)
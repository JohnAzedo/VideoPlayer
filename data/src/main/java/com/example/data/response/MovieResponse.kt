package com.example.data.response

import com.example.domain.usecases.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val imageUrl: String,
)


fun MovieResponse.toMovie() = com.example.domain.usecases.Movie(
    id = this.id,
    title = this.title,
    imageUrl = "https://image.tmdb.org/t/p/w500" + this.imageUrl,
    description = this.description
)
package com.example.data.response

import com.example.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("backdrop_path")
    val imageUrl: String,
)


fun MovieResponse.toMovie() = Movie (
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    description = this.description
)
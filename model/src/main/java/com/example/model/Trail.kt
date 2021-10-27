package com.example.model

data class Trail(
    var id: Int,
    var title: String,
    var movies: List<Movie>? = listOf()
)
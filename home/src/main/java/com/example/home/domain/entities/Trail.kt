package com.example.home.domain.entities

data class Trail(
    var id: Int,
    var title: String,
    var movies: List<Movie>? = listOf()
)
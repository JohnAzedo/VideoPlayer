package com.example.domain.usecases

data class Trail(
    var id: Int,
    var title: String,
    var movies: List<com.example.domain.usecases.Movie>? = listOf()
)
package com.example.videoplayer

import com.example.domain.usecases.Movie
import com.example.domain.usecases.Trail

object ViewModelStubs {

    val listOfTrails = listOf(
        Trail(id = 1, title = "Action", movies = listOf())
    )

    val listOfMovies = listOf(
        Movie(1, "Spider-man", "Three spiders-man", "random")
    )
}
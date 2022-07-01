package com.example.videoplayer.features.mylist

import com.example.domain.usecases.Movie
import com.example.videoplayer.generics.State

data class MyListState(
    val value: List<Movie>
): State
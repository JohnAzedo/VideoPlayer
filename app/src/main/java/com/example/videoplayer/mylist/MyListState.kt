package com.example.videoplayer.mylist

import com.example.model.Movie
import com.example.videoplayer.State

data class MyListState(
    val value: List<Movie>
): State
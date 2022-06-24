package com.example.ui.mylist

import com.example.model.Movie
import com.example.ui.State

data class MyListState(
    val value: List<Movie>
): State
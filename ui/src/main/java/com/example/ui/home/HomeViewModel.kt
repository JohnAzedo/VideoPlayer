package com.example.ui.home

import androidx.lifecycle.ViewModel
import com.example.data.repositories.MovieRepository

class HomeViewModel(
    private val repository: MovieRepository
): ViewModel() {
}
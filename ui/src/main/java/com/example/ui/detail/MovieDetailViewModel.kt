package com.example.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetMovieUseCase
import com.example.model.Movie
import com.example.model.Trail
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieUseCase: GetMovieUseCase
) : ViewModel(){

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    fun getMovie(movieId: Int) {
        viewModelScope.launch {
            movieUseCase.getMovie(movieId)
        }
    }


}
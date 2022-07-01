package com.example.videoplayer.features.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Movie
import com.example.domain.usecases.GetMovieUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieUseCase: GetMovieUseCase
) : ViewModel(){

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    fun getMovie(movieId: Int) {
        viewModelScope.launch {
            _movie.postValue(movieUseCase.getMovie(movieId))
        }
    }


}
package com.example.ui.mylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetMovieUseCase
import com.example.model.Movie
import kotlinx.coroutines.launch

class MyListViewModel(
    private val useCase: GetMovieUseCase
): ViewModel(){

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun getMovies() {
        viewModelScope.launch {
            val list = useCase.getMoviesMock()
            _movies.postValue(list)
        }
    }


}
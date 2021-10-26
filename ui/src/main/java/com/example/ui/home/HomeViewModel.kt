package com.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetMovieUseCase
import com.example.domain.usecases.GetTrailsUseCase
import com.example.model.Trail
import kotlinx.coroutines.launch

class HomeViewModel(
    private val trailUseCase: GetTrailsUseCase,
    private val movieUseCase: GetMovieUseCase
): ViewModel() {

    private val _trails = MutableLiveData<List<Trail>>()
    val trails: LiveData<List<Trail>> get() = _trails

    fun getTrails() {
        viewModelScope.launch {
            val listTrail = trailUseCase.getTrails()
            listTrail[0].movies = movieUseCase.getMoviesMock()
            _trails.postValue(listTrail)
        }
    }
}
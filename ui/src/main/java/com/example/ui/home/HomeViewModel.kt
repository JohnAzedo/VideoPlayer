package com.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.TrailUseCase
import com.example.model.Trail
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: TrailUseCase
): ViewModel() {

    private val _trails = MutableLiveData<List<Trail>>()
    val trails: LiveData<List<Trail>> get() = _trails

    fun getTrails() {
        viewModelScope.launch {
            val list = useCase.getTrails()
            _trails.postValue(list)
        }
    }
}
package com.example.videoplayer.mylist

import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetMovieUseCase
import com.example.videoplayer.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyListViewModel(
    private val useCase: GetMovieUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel<MyListState, MyListActions>(){

    fun getMovies() {
        viewModelScope.launch(dispatcher) {
            val movies = useCase.getMoviesMock()
            setState(MyListState(movies))
        }
    }
}
package com.example.ui.mylist

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetMovieUseCaseImpl


object MyListViewModelFactory {
    private class Factory: ViewModelProvider.Factory {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            val movieUseCase = GetMovieUseCaseImpl()
            return MyListViewModel(movieUseCase) as T
        }
    }

    fun Fragment.make(): MyListViewModel {
        return ViewModelProvider(this, Factory()).get(MyListViewModel::class.java)
    }
}


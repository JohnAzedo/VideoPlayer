package com.example.videoplayer.viewmodels

import com.example.domain.usecases.GetMovieUseCase
import com.example.videoplayer.ViewModelStubs
import com.example.videoplayer.ViewModelTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MyListViewModelTest: ViewModelTest() {

    private val useCase = mockk<GetMovieUseCase>()
    private lateinit var viewModel: com.example.videoplayer.mylist.MyListViewModel

    @Before
    fun setup(){
        viewModel = com.example.videoplayer.mylist.MyListViewModel(useCase, testDispatcher)
    }

    @Test
    fun `Get favorite movies from useCase`(){
        val movies = ViewModelStubs.listOfMovies
        coEvery { useCase.getMoviesMock() } returns movies
        // When
        viewModel.getMovies()
        val state = viewModel.state.value

        // Then
        assert(state?.value == movies)
    }

}
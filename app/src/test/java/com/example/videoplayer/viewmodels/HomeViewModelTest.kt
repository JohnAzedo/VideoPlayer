package com.example.videoplayer.viewmodels

import com.example.domain.usecases.GetTrailsUseCase
import com.example.videoplayer.ViewModelTest
import com.example.videoplayer.ViewModelStubs
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest: ViewModelTest() {

    private val useCase = mockk<GetTrailsUseCase>()
    private lateinit var viewModel: com.example.videoplayer.home.HomeViewModel

    @Before
    fun setup(){
        viewModel = com.example.videoplayer.home.HomeViewModel(useCase, testDispatcher)
    }

    @Test
    fun `Get trails from useCase`() = runBlockingTest {
        val listOfTrails = ViewModelStubs.listOfTrails
        coEvery { useCase.getTrails() } returns listOfTrails
        // When
        viewModel.getTrails()
        // Then
        val state = viewModel.state.value
        val action = viewModel.actions.value
        coVerify { useCase.getTrails() }
        assert(state?.value == listOfTrails)
        assert(action == com.example.videoplayer.home.HomeAction.HideLoader)
    }
}
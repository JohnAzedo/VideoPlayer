package com.example.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.usecases.GetTrailsUseCase
import com.example.ui.MainCoroutineRule
import com.example.ui.ViewModelStubs
import com.example.ui.home.HomeViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private var testDispatcher = TestCoroutineDispatcher()
    private val useCase = mockk<GetTrailsUseCase>()
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup(){
        viewModel = HomeViewModel(useCase, testDispatcher)
    }

    @Test
    fun `Get trails from useCase`() = runBlockingTest {
        val listOfTrails = ViewModelStubs.listOfTrails
        coEvery { useCase.getTrails() } returns listOfTrails
        // When
        viewModel.getTrails()
        // Then
        val state = viewModel.state.value
        coVerify { useCase.getTrails() }
        assert(state?.value == listOfTrails)
    }
}
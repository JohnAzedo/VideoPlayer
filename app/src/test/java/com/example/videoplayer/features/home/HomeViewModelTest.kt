package com.example.videoplayer.features.home

import androidx.lifecycle.Observer
import com.example.domain.entities.Trail
import com.example.domain.usecases.GetTrailsUseCase
import com.example.videoplayer.ViewModelTest
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest: ViewModelTest() {

    private val useCase = mockk<GetTrailsUseCase>()
    private lateinit var viewModel: HomeViewModel

    private var stateObserver: Observer<HomeState> = mockk(relaxed = true)
    private var actionObserver: Observer<HomeAction> = mockk(relaxed = true)

    @Before
    fun setup(){
        viewModel = HomeViewModel(useCase, testDispatcher)
        viewModel.state.observeForever(stateObserver)
    }

    @Test
    fun `getTrails Should fetch all trails and update state`() = runTest {
        coEvery { useCase.getTrails() } answers { LIST_TRAILS }

        // When
        viewModel.getTrails()

        // Then
        verifyOrder {
            stateObserver.onChanged(INITIAL_STATE)
            stateObserver.onChanged(VALID_STATE)
        }
    }

    companion object {
        val LIST_TRAILS = listOf(
            Trail(
                10001,
                "Action",
                listOf()
            )
        )

        val INITIAL_STATE = HomeState(listOf())
        val VALID_STATE = HomeState(LIST_TRAILS)
    }
}
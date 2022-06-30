package com.example.videoplayer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Rule

@ExperimentalCoroutinesApi
abstract class ViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    protected var testDispatcher = TestCoroutineDispatcher()

}
package com.example.home.data


import app.cash.turbine.test
import com.example.tools.errors.NetworkError
import com.example.home.data.services.HomeService
import com.example.test.WebTool
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {

    private lateinit var repository: MovieRepositoryImpl
    private lateinit var webTool: WebTool

    @Before
    fun setup() {
        webTool = WebTool()
        val service = webTool.startServer(HomeService::class.java)
        repository = MovieRepositoryImpl(service)
    }

    @After
    fun stop() {
        webTool.stopServer()
    }

    @Test
    fun `getTrail Should return a success with data`() = runTest {
        // Given
        webTool.enqueueResponse("list_trails_success.json")

        // When
        val result = repository.getTrails()

        // Then
        result.test {
            assert(awaitItem().isNotEmpty())
            awaitComplete()
        }
    }

    @Test(expected = NetworkError::class)
    fun `getTrail Should return a GeneralError with code 500`() = runTest {
        // Given
        webTool.enqueueError(500, "")

        // When
        val result = repository.getTrails()

        // Then
        result.test {
            throw awaitError()
        }
    }
}

package com.example.home.data


import app.cash.turbine.test
import com.example.commons.errors.NetworkError
import com.example.home.data.services.HomeService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.After
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {

    private lateinit var server: MockWebServer
    private lateinit var repository: MovieRepositoryImpl

    @Before
    fun setup() {
        server = MockWebServer()
        val gson = GsonConverterFactory.create(GsonBuilder().setLenient().create())
        val retrofit = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(gson)
            .build()

        val service = retrofit.create(HomeService::class.java)
        repository = MovieRepositoryImpl(service)
    }

    @After
    fun stop() {
        server.shutdown()
    }

    @Test
    fun `getTrail Should return a success with data`() = runTest {
        // Given
        enqueueResponse("list_trails_success.json")

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
        enqueueError(500, "")

        // When
        val result = repository.getTrails()

        // Then
        result.test {
            throw awaitError()
        }
    }


    private fun enqueueResponse(filename: String, headers: Map<String, String> = emptyMap()) {
        val path = "/Users/joaolimao/Documents/GitHub/playmovie/home/src/test/resources/$filename"
        val file = File(path).readText(Charsets.UTF_8)
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        server.enqueue(mockResponse.setBody(file))
    }

    private fun enqueueError(errorCode: Int, body: String){
        val response = MockResponse().setResponseCode(errorCode).setBody(body)
        server.enqueue(response)
    }
}

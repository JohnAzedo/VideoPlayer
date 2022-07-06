package com.example.data

import com.example.data.config.RetrofitClient
import com.example.data.repositories.MovieRepositoryImpl
import com.example.data.services.MovieService
import com.example.domain.repositories.MovieRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@ExperimentalCoroutinesApi
class GetMovieRepositoryIntegrationTest {

    private lateinit var server: MockWebServer
    private lateinit var repository: MovieRepository

    @Before
    fun setup() {
        server = MockWebServer()
        val gson = GsonConverterFactory.create(GsonBuilder().setLenient().create())
        val retrofit = Retrofit.Builder()
                .baseUrl(server.url("products/"))
                .addConverterFactory(gson)
                .build()
        val service = retrofit.create(MovieService::class.java)
        repository = MovieRepositoryImpl(service)
    }

    @Test
    fun testGetMovies() = runTest {

    }

    private fun setResponse(filename: String, headers: Map<String, String> = emptyMap()) {
        val path = "src/test/java/com/example/mockwebserverexample/resources/$filename"
        val file = File(path).readText(Charsets.UTF_8)
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        server.enqueue(mockResponse.setBody(file))
    }


}
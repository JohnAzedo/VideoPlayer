package com.example.home.data

import com.example.commons.network.RetrofitClient
import com.example.home.data.services.HomeService
import org.junit.After
import org.junit.Before
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test


class MovieRepositoryImplTest {

    private val server = MockWebServer()
    private val repository = createRepository()

    @After
    fun stop() {
        server.shutdown()
    }

    @Test
    fun `testing MockWebServer`() {

    }

    private fun createRepository(): MovieRepositoryImpl {
        val service = RetrofitClient.buildService(HomeService::class.java)
        return MovieRepositoryImpl(service)
    }
}


//private fun enqueueResponse(filename: String, headers: Map<String, String> = emptyMap()) {
//    val path = "src/test/java/com/picpay/desafio/android/data/repositories/resources/$filename"
//    val file = File(path).readText(Charsets.UTF_8)
//    val mockResponse = MockResponse()
//    for ((key, value) in headers) { mockResponse.addHeader(key, value) }
//    server.enqueue(mockResponse.setBody(file))
//}


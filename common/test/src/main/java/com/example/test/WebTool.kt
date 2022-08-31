package com.example.test

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.io.File

class WebTool {
    private lateinit var server: MockWebServer

    fun<T> startServer(serviceClass: Class<T>): T {
        server = MockWebServer()
        val client = RetrofitClientTest.getRetrofit(server.url("/"))
        return client.create(serviceClass)
    }

    fun stopServer() {
        server.shutdown()
    }

    fun enqueueResponse(filename: String, headers: Map<String, String> = emptyMap()) {
        val path = "/Users/joaolimao/Documents/GitHub/playmovie/home/src/test/resources/$filename"
        val file = File(path).readText(Charsets.UTF_8)
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        server.enqueue(mockResponse.setBody(file))
    }

    fun enqueueError(errorCode: Int, body: String){
        val response = MockResponse().setResponseCode(errorCode).setBody(body)
        server.enqueue(response)
    }
}
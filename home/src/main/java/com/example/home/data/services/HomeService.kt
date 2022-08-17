package com.example.home.data.services

import com.example.home.data.responses.TrailResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("/home")
    suspend fun getHomeService(): Response<TrailResponse>
}
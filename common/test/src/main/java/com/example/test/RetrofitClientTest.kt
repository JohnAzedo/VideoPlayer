package com.example.test

import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientTest {
    private val gson = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    fun getRetrofit(url: HttpUrl): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(gson)
            .build()
    }
}
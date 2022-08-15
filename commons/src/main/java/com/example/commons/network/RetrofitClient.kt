package com.example.commons.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.commons.BuildConfig

object RetrofitClient {
    private val client = OkHttpClient.Builder()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(buildClient())
        .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    private fun buildClient(): OkHttpClient {
        client.addInterceptor(ApiKeyInterceptor())
        return client.build()
    }
}

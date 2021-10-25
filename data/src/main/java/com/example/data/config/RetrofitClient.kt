package com.example.data.config
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL: String = "https://api.themoviedb.org/3/"
    private val client = OkHttpClient.Builder()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(buildClient())
        .build()

    fun<T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    private fun buildClient(): OkHttpClient {
        client.addInterceptor(CustomInterceptor())
        return client.build()
    }
}








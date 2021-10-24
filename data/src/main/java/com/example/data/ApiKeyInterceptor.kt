package com.example.data

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val url: HttpUrl = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(request.newBuilder().url(url).build())
    }

}
package com.example.data.config

import retrofit2.Response
import java.net.HttpURLConnection


sealed class Output <out Response>{
    data class Success<Response> (val value: Response): Output<Response>()
    data class Failure(val statusCode: Int): Output<Nothing>()
}

fun <R: Any> Response<R>.parseResponse(): Output<R> {
    if(isSuccessful) {
        val body = body()
        print(body)
        if(body != null) {
            return Output.Success(body)
        }
    } else {
        return Output.Failure(code())
    }

    return Output.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
}

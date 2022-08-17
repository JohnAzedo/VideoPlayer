package com.example.commons.network

import com.example.commons.errors.NetworkErrors
import kotlinx.coroutines.flow.flow
import retrofit2.Response


fun <A: Any> Response<A>.result() = flow {
    val body = body()
    val code = code()
    when {
        isSuccessful && body != null -> emit(body)
        isSuccessful && body == null -> throw NetworkErrors.InternalServerError()
        else -> throw NetworkErrors.GeneralError(code = code)
    }
}
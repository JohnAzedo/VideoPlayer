package com.example.commons.network

import com.example.commons.errors.NetworkErrors
import retrofit2.Response


fun <A: Any> Response<A>.onError(lambda: (t: Throwable) -> Unit): Response<A> {
    val body = body()
    if(isSuccessful && body != null) lambda(NetworkErrors.InternalServerError())
    if(!isSuccessful) lambda(NetworkErrors.GeneralError(code = code(), errorBody = errorBody()))
    return this
}

suspend fun <A: Any> Response<A>.onSuccess(lambda: suspend (A) -> Unit): Response<A> {
    val body = body()
    if(isSuccessful && body != null) lambda(body)
    return this
}

suspend fun <A: Any> Response<A>.result(lambda: suspend Response<A>.() -> Unit){
    lambda()
}
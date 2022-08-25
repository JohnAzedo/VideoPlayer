package com.example.commons.network

import com.example.commons.errors.NetworkError
import retrofit2.Response


fun <A: Any> Response<A>.onError(lambda: (t: Throwable) -> Unit): Response<A> {
    if(!isValid()) {
        val code = code()
        val errorBody = errorBody()
        lambda(NetworkError(code, errorBody))
    }
    return this
}

suspend fun <A: Any> Response<A>.onSuccess(lambda: suspend (A) -> Unit): Response<A> {
    if(isValid()) lambda(body()!!)
    return this
}

suspend fun <A: Any> Response<A>.result(lambda: suspend Response<A>.() -> Unit){
    lambda()
}

private fun <A:Any> Response<A>.isValid(): Boolean {
    return isSuccessful && body() != null
}
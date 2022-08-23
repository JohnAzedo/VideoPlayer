package com.example.commons.network

import com.example.commons.errors.NetworkErrors
import retrofit2.Response


//fun <A: Any> Response<A>.result() = flow {
//    val body = body()
//    val code = code()
//    when {
//        isSuccessful && body != null -> emit(body)
//        isSuccessful && body == null -> throw NetworkErrors.InternalServerError()
//        else -> throw NetworkErrors.GeneralError(code = code)
//    }
//}

fun <A: Any> Response<A>.onError(lambda: (t: Throwable) -> Unit): Response<A> {
    val body = body()
    if(!isSuccessful){
        lambda(
            when(body) {
                null -> NetworkErrors.InternalServerError()
                else -> NetworkErrors.GeneralError(code = code())
            }
        )
    }
    return this
}

suspend fun <A: Any> Response<A>.onSuccess(lambda: suspend (A) -> Unit): Response<A> {
    val body = body()
    if(isSuccessful && body != null) lambda(body)
    return this
}
package com.example.commons.network

import retrofit2.Response

sealed interface Result <out S> {
    data class Success<A> (val value: A): Result<A>
    data class Failure(val errorStatus: Int): Result<Nothing>
}

const val INTERNAL_SERVER_ERROR = 500
fun <A: Any> Response<A>.result()= run  {
    val body = body()
    when {
        isSuccessful && body != null -> Result.Success(body)
        isSuccessful && body == null -> Result.Failure(INTERNAL_SERVER_ERROR)
        else -> Result.Failure(code())
    }
}

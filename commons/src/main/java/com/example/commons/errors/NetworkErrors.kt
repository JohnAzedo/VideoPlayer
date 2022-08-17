package com.example.commons.errors

open class NetworkErrors: Throwable(){
    data class InternalServerError(val code: Int = 500): NetworkErrors()
    data class GeneralError(
        val errorBody: String? = null,
        val code: Int
    ): NetworkErrors()
}
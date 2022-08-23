package com.example.commons.errors

import okhttp3.ResponseBody

open class NetworkErrors: Throwable(){
    data class InternalServerError(val code: Int = 500): NetworkErrors()
    data class GeneralError(
        val errorBody: ResponseBody? = null,
        val code: Int
    ): NetworkErrors()
}
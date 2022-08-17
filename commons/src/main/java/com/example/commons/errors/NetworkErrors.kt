package com.example.commons.errors

class InternalServerError: Throwable() {
    override val message: String
        get() = "Unknown error"
}

data class NetworkError(
    private val errorBody: String? = null,
    private val code: Int
): Throwable() {
    override val message: String
        get() = "General network error"
}
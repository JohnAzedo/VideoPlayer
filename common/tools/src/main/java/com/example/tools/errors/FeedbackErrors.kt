package com.example.tools.errors

open class FeedbackErrors: Throwable(){
    data class GeneralError(var serviceMessage: String? = null): FeedbackErrors()
    object NoInternetError: FeedbackErrors()
}

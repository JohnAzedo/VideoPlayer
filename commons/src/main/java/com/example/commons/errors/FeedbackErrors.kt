package com.example.commons.errors

open class FeedbackErrors: Throwable(){
    data class GeneralError(var serviceMessage: String? = null): FeedbackErrors()
    object NoInternetError: FeedbackErrors()
}

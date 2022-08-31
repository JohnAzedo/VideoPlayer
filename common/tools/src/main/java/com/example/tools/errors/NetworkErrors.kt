package com.example.tools.errors

import okhttp3.ResponseBody


class NetworkError(val code: Int = 500, errorBody: ResponseBody? = null): Throwable()

class MapperError(): Throwable()
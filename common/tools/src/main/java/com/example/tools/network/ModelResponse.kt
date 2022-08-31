package com.example.tools.network

import kotlin.reflect.full.memberProperties

interface ModelResponse {
    fun isValid(): Boolean
}

//inline fun <reified T : Any> T.getComponents() =
//    T::class.memberProperties.map { it.name to it.get(this) }
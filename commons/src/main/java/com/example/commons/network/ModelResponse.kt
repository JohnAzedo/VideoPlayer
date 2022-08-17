package com.example.commons.network

import kotlin.reflect.full.memberProperties

interface ModelResponse<T> {
    fun toDomain(): T
}

inline fun <reified T : Any> T.getComponents() =
    T::class.memberProperties.map { it.name to it.get(this) }
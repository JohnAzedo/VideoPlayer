package com.example.commons

internal class ReadFile {
    operator fun invoke(path: String) = this.javaClass.classLoader?.getResource(path)?.readText()
}
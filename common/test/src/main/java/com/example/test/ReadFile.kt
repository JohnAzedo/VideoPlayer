package com.example.test

internal class ReadFile {
    operator fun invoke(path: String) = this.javaClass.classLoader?.getResource(path)?.readText()
}
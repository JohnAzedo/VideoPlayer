package com.example.videoplayer

class VideoRepository {

    private val data = listOf(
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),
        Video(title = "Test 01", author = "Author 01", url = "URL 01"),
        Video(title = "Test 02", author = "Author 02", url = "URL 02"),
        Video(title = "Test 03", author = "Author 03", url = "URL 03"),

    )


    fun getVideos(): List<Video> {
        return data
    }

}
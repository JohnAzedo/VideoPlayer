package com.example.home.data.responses

import com.example.tools.network.ModelResponse
import com.google.gson.annotations.SerializedName

data class TrailResponse (
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("movies")
    var movies: List<MovieResponse> = listOf()
): ModelResponse {
    override fun isValid(): Boolean {
        return id != null && title != null && movies.isNotEmpty()
    }
}
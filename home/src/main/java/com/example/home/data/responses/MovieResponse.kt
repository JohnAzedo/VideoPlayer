package com.example.home.data.responses
import com.example.tools.network.ModelResponse
import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
): ModelResponse {
    override fun isValid(): Boolean {
        return id != null && title != null && description != null && imageUrl != null
    }
}
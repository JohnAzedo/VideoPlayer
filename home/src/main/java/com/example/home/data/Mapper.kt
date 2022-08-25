package com.example.home.data

import com.example.commons.errors.FeedbackErrors
import com.example.home.data.responses.MovieResponse
import com.example.home.data.responses.TrailResponse
import com.example.home.domain.entities.Movie
import com.example.home.domain.entities.Trail

object Mapper {
    fun make(response: List<TrailResponse>): List<Trail> {
        return when(response.isEmpty()) {
            true -> throw FeedbackErrors.GeneralError()
            false -> response
                .filter { it.isValid() }
                .map { toTrail(it) }
        }
    }

    private fun toTrail(response: TrailResponse): Trail {
        val movies = response.movies
            .filter { it.isValid() }
            .map { toMovie(it) }

        return Trail(
            id = response.id!!,
            title = response.title!!,
            movies = movies
        )
    }

    private fun toMovie(response: MovieResponse): Movie {
        return Movie(
            id = response.id!!,
            title = response.title!!,
            imageUrl = response.imageUrl!!,
            description = response.description!!
        )
    }
}
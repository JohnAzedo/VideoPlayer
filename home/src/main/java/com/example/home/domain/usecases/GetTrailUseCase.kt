package com.example.home.domain.usecases

import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrailUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<List<Trail>> {
        return repository.getTrails()
    }
}
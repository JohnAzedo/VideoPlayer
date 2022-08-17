package com.example.home.domain.usecases

import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetTrailUseCase(
    private val repository: HomeRepository
) {
    operator fun invoke(): Flow<List<Trail>> {
        return repository.getTrails()
    }
}
package com.example.domain.usecases

import com.example.model.Trail

class GetTrailsUseCaseImpl: GetTrailsUseCase{
    override suspend fun getTrails(): List<Trail> {
        return listOf(
            Trail(
                id = 28,
                title = "Ação",
                movies = listOf()
            ),
        )
    }


}

interface GetTrailsUseCase {
    suspend fun getTrails(): List<Trail>
}
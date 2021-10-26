package com.example.domain.usecases

import com.example.model.Trail

class GetTrailsUseCaseImpl: GetTrailsUseCase{
    override suspend fun getTrails(): List<Trail> {
        return listOf(
            Trail(
                title = "Ação",
                movies = listOf()
            ),
            Trail(
                title = "Ficcão",
                movies = listOf()
            ),
            Trail(
                title = "Comédia",
                movies = listOf()
            ),
        )
    }


}

interface GetTrailsUseCase {
    suspend fun getTrails(): List<Trail>
}
package com.example.domain.usecases

import com.example.model.Trail

class TrailUseCaseImpl: TrailUseCase{
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

interface TrailUseCase {
    suspend fun getTrails(): List<Trail>
}
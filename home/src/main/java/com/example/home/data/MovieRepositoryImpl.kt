package com.example.home.data

import com.example.home.data.services.HomeService
import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MovieRepositoryImpl(val service: HomeService): MovieRepository {
    override fun getTrails(): Flow<List<Trail>> {
        return flow {
            val a = service.getHomeService()
            throw Throwable("Not implemented")
        }
    }
}
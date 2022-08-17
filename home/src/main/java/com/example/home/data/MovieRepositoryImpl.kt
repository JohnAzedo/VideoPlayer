package com.example.home.data

import com.example.commons.network.Result
import com.example.commons.network.result
import com.example.home.data.responses.TrailResponse
import com.example.home.data.services.HomeService
import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MovieRepositoryImpl(private val service: HomeService) : HomeRepository {
    override fun getTrails(): Flow<List<Trail>> = flow {
        val response = service.getHomeService()
        when (val result = response.result()) {
            is Result.Success -> throw Throwable()
            is Result.Failure -> throw Throwable()
        }
    }
}
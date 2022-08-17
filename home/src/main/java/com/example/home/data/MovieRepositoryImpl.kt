package com.example.home.data

import com.example.commons.errors.FeedbackErrors
import com.example.commons.network.result
import com.example.home.data.services.HomeService
import com.example.home.domain.entities.Trail
import com.example.home.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class MovieRepositoryImpl(private val service: HomeService) : HomeRepository {
    override fun getTrails(): Flow<List<Trail>> = flow {
        service.getHomeService().result()
            .catch { throw FeedbackErrors.GeneralError() }
            .collect {
                val result = Mapper.make(it)
                emit(result)
            }
    }
}
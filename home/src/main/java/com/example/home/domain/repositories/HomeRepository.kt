package com.example.home.domain.repositories

import com.example.home.domain.entities.Trail
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getTrails(): Flow<List<Trail>>
}
package com.example.home.domain.repositories

import com.example.home.domain.entities.Trail
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTrails(): Flow<List<Trail>>
}
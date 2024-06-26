package com.davidperezcontreras.kotlincoroutines1.domain.repository

import com.davidperezcontreras.kotlincoroutines1.domain.models.Data
import kotlinx.coroutines.Deferred

interface DataRepository {
    suspend fun fetchData(): Data
}
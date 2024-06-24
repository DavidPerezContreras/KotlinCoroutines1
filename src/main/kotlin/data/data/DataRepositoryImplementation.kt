package com.davidperezcontreras.kotlincoroutines1.data.data

import com.davidperezcontreras.kotlincoroutines1.data.data.remote.DataRemoteImplementation
import com.davidperezcontreras.kotlincoroutines1.domain.models.Data
import com.davidperezcontreras.kotlincoroutines1.domain.repository.DataRepository
import kotlinx.coroutines.*

class DataRepositoryImplementation(
    private val dataRemoteImplementation: DataRemoteImplementation
) : DataRepository {
    override suspend fun fetchData(): Data {
        return dataRemoteImplementation.fetchData()
    }

}
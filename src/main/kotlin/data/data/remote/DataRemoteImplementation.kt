package com.davidperezcontreras.kotlincoroutines1.data.data.remote

import com.davidperezcontreras.kotlincoroutines1.domain.models.Data
import kotlinx.coroutines.*

class DataRemoteImplementation {

    suspend fun fetchData(): Data {
         // Simulate a long-running operation
        return withContext(Dispatchers.IO){
            delay(1000)
            Data(username = "david", password = "12345")
        }
    }
}
package com.davidperezcontreras.kotlincoroutines1.data.data.remote

import com.davidperezcontreras.kotlincoroutines1.domain.models.Data
import kotlinx.coroutines.*

class DataRemoteImplementation {
    fun fetchData(): Deferred<Data> = CoroutineScope(Dispatchers.IO).async {
        delay(1000) // Simulate a long-running operation
        return@async Data(username = "david", password = "12345")
    }
}
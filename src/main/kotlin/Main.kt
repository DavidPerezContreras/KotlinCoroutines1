package com.davidperezcontreras.kotlincoroutines1

import com.davidperezcontreras.kotlincoroutines1.data.data.DataRepositoryImplementation
import com.davidperezcontreras.kotlincoroutines1.data.data.remote.DataRemoteImplementation
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val dataRepository = DataRepositoryImplementation(DataRemoteImplementation())

    launch(){
        val username:String  = dataRepository.fetchData().username
        print(username)
    }
    print("end")

}

package com.example.core.data.source.remote

import com.example.core.data.source.Resource
import io.ktor.client.network.sockets.SocketTimeoutException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

interface SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (t: Throwable) {
                when(t) {
                    is SocketTimeoutException -> {
                        Resource.Error(null, t.message ?: "Check your internet connection")
                    }
                    is IOException -> {
                        Resource.Error(-1, t.message ?: "Ups, something error with your internet connection")
                    }
                    else -> {
                        Resource.Error(-1, t.message ?: "Ups, something error!")
                    }
                }
            }
        }
    }
}
package com.example.core.data.source

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val statusCode: Int? = null, val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()

}
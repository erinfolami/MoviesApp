package com.example.moviesapp.network.retrofit

/**
 * Wrapper for data provided from the Network
 */
sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : NetworkResult<T>(data)

    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)

    class Loading<T> : NetworkResult<T>()
}
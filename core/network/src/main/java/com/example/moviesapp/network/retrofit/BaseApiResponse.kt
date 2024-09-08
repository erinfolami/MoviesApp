package com.example.moviesapp.network.retrofit

import android.util.Log
import retrofit2.Response

abstract class BaseApiResponse {

    private val tag = "BaseApiResponse"

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Log.d(tag, "Network Response Success ${response.code()} - ${response.message()}")
                    NetworkResult.Success(body)
                } else {
                    Log.w(tag, "Network Response body is null")
                    NetworkResult.Error("Network Response body is null")
                }
            } else {
                Log.e(tag, "Network Response Error ${response.code()}: ${response.message()}")
                NetworkResult.Error("Network Response Error ${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e(tag, "Network Response Exception: ${e.localizedMessage ?: e.toString()}")
            NetworkResult.Error("Network Response Exception: ${e.localizedMessage ?: e.toString()}")
        }
    }
}



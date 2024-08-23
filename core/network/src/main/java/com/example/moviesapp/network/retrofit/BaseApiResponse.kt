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
                    NetworkResult.Success(body)
                } else {
                    Log.e(tag, "Response body is null")
                    NetworkResult.Error("Response body is null")
                }
            } else {
                Log.e(tag, "Response Error ${response.code()}: ${response.message()}")
                NetworkResult.Error("Response Error ${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e(tag, "Response Exception: ${e.localizedMessage ?: e.toString()}")
            NetworkResult.Error("Response Exception: ${e.localizedMessage ?: e.toString()}")
        }
    }
}



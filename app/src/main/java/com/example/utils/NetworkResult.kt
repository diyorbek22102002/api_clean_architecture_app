package com.example.utils

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : NetworkResult<T>(data = data)
    class Error<T>(data: T?, message: String?) : NetworkResult<T>(data = data, message = message)
    class Loading<T>(): NetworkResult<T>()

}
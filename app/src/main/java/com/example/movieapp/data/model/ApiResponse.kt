package com.example.movieapp.data.model

import retrofit2.Response

sealed class ApiResponse<T> {

    class ApiEmptyResponse<T>: ApiResponse<T>()

    data class ApiError<T>(val errorMessage: String): ApiResponse<T>()

    data class ApiSuccessResponse<T>(val body: T): ApiResponse<T>()

}

fun <T> Response<T>.handleResponse(): ApiResponse<T> {
    return if (isSuccessful) {
        val body = body()
        if (body == null || code() == 204) {
            ApiResponse.ApiEmptyResponse()
        } else {
            ApiResponse.ApiSuccessResponse(body)
        }
    } else {
        val msg = errorBody()?.string()
        val errorMsg = if (msg.isNullOrEmpty()) {
            message()
        } else {
            msg
        }
        ApiResponse.ApiError(errorMsg)
    }

}
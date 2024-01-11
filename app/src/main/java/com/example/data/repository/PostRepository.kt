package com.example.data.repository

import com.example.data.api.RemoteDataSource
import com.example.data.api.model.PostResponse
import com.example.utils.BaseApiResponse
import com.example.utils.NetworkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getAllPost(): NetworkResult<List<PostResponse>> {
        return safeApiCall { remoteDataSource.getAllPost() }
    }

    suspend fun postPost(body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.postPost(body = body) }
    }

    suspend fun putPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.putPost(id = id, body = body) }
    }

    suspend fun patchPost(id: String, body: PostResponse): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.patchPost(id = id, body = body) }
    }

    suspend fun deletePost(id: String): NetworkResult<PostResponse> {
        return safeApiCall { remoteDataSource.deletePost(id = id) }
    }



}
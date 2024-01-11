package com.example.domain.usecases

import com.example.data.api.model.PostResponse
import com.example.data.repository.PostRepository
import javax.inject.Inject

class PostPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(body: PostResponse) = postRepository.postPost(body = body)
}
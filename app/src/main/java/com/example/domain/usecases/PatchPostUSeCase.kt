package com.example.domain.usecases

import com.example.data.api.model.PostResponse
import com.example.data.repository.PostRepository
import javax.inject.Inject

class PatchPostUSeCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun invoke(id: String,body: PostResponse) = postRepository.patchPost(id = id,body = body)
}
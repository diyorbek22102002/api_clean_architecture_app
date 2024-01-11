package com.example.data.api

import com.example.data.api.model.PostResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val postService: PostService) {
    // Этот функция получает весь список
    suspend fun getAllPost() = postService.getAllPost()


    // Этот функция отправляет данные на сервер
    suspend fun postPost(body: PostResponse) = postService.postPost(body = body)


    // Этот функция обновляет пользователя
    suspend fun putPost(id: String, body: PostResponse) = postService.putPost(id = id, body = body)


    // Этот функция частично обновляет пользователя
    suspend fun patchPost(id: String, body: PostResponse) =
        postService.patchPost(id = id, body = body)


    // Этот функция удаляет пользователя
    suspend fun deletePost(id: String) = postService.deletePost(id = id)

}
package com.example.presentation.restapiappp.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.model.PostResponse
import com.example.domain.usecases.DeletePostUseCase
import com.example.domain.usecases.GetAllPostUseCase
import com.example.domain.usecases.PatchPostUSeCase
import com.example.domain.usecases.PostPostUseCase
import com.example.domain.usecases.PutPostUseCase
import com.example.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val getAllPostUseCase: GetAllPostUseCase,
    private val patchPostUSeCase: PatchPostUSeCase,
    private val postPostUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase
) : ViewModel() {

    private val _allPostResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse: LiveData<NetworkResult<List<PostResponse>>>
        get() = _allPostResponse


    init {
        getAllPosts()

    }


    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostUseCase.invoke().let {
                _allPostResponse.value = it
            }
        }
    }


    private fun postPost() {
        viewModelScope.launch {
            postPostUseCase.invoke(body = PostResponse(title = "test Title", body = "test body"))
        }
    }

    fun putPost() {
        viewModelScope.launch {
            putPostUseCase.invoke(
                id = "1",
                body = PostResponse(title = "test Title", body = "test body")
            )
        }
    }

    fun patchPost() {
        viewModelScope.launch {
            patchPostUSeCase.invoke(
                id = "1",
                body = PostResponse(title = "test Title", body = "test body")
            ).let {
                Log.e("checkData", it.data.toString())
            }
        }
    }

    fun deletePost() {
        viewModelScope.launch {
            deletePostUseCase.invoke(id = "1").let {
                Log.e("checkDat", it.data.toString())
            }
        }
    }


}
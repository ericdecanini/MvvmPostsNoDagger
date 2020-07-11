package com.ericdecanini.mvvmpractice

import com.ericdecanini.mvvmpractice.api.PostsApiService


class MainRepository {

    private val apiService = PostsApiService()

    suspend fun getPosts() = apiService.getPosts()

}
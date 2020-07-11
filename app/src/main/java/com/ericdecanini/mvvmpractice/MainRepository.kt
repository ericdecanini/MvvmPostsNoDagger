package com.ericdecanini.mvvmpractice

import com.ericdecanini.mvvmpractice.api.Post
import com.ericdecanini.mvvmpractice.api.PostsApiService

class MainRepository {

    private val postsApiService = PostsApiService()

    suspend fun getPosts(): List<Post> {
        return postsApiService.getPosts()
    }

}
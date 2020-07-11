package com.ericdecanini.mvvmpractice.api

import retrofit2.http.GET

interface PostsApi {

    @GET("posts/")
    suspend fun getPosts(): List<Post>

}
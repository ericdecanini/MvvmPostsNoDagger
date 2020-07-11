package com.ericdecanini.mvvmpractice.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.lang.RuntimeException

class PostsApiService {

    private val postsApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostsApi::class.java)

    suspend fun getPosts(): List<Post> {
        return postsApi.getPosts()
    }

}
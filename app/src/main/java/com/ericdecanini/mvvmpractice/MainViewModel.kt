package com.ericdecanini.mvvmpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericdecanini.mvvmpractice.api.Post
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = MainRepository()
    val postsLiveData = MutableLiveData<List<Post>>()

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            val posts = repository.getPosts()
            postsLiveData.postValue(posts)
        }
    }

}
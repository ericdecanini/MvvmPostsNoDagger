package com.ericdecanini.mvvmpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment: Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var adapter = PostsAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observePosts()
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().posts_recycler.adapter = adapter
        requireView().posts_recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observePosts() {
        viewModel.postsLiveData.observe(viewLifecycleOwner, Observer { posts ->
            adapter.posts.clear()
            adapter.posts.addAll(posts)
            adapter.notifyDataSetChanged()
        })
    }
}
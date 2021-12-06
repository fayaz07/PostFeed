package com.mohammadfayaz.postfeed.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.google.android.material.snackbar.Snackbar
import com.mohammadfayaz.postfeed.databinding.FragmentPostFeedBinding
import com.mohammadfayaz.postfeed.ui.adapter.loading_adapter.LoadingIndicatorAdapter
import com.mohammadfayaz.postfeed.ui.adapter.posts.PostListAdapter
import com.mohammadfayaz.postfeed.utils.ViewEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Error

@AndroidEntryPoint
class PostFeedFragment : Fragment() {

  private val viewModel: PostFeedViewModel by viewModels()
  private lateinit var binding: FragmentPostFeedBinding

  private lateinit var adapter: PostListAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPostFeedBinding.inflate(layoutInflater)

    registerViewEvents()
    addObservers()

    return binding.root
  }

  private fun addObservers() {

    lifecycleScope.launch {
      viewModel.getPaginatedFlow().collect {
//        idle()
        adapter.submitData(it)
      }
    }

    adapter.addLoadStateListener { loadStates ->
      binding.progressBar.isVisible = loadStates.refresh is LoadState.Loading
      if (loadStates.refresh is LoadState.Error){
        Snackbar.make(binding.root, "There is an error", Snackbar.LENGTH_SHORT).show()
      }
    }

//    viewModel.viewEvents.observe(viewLifecycleOwner) {
//      when (it) {
//        is ViewEvent.Idle -> {
//          idle()
//        }
//        is ViewEvent.Error<*> -> {
//          Snackbar.make(binding.root, it.error, Snackbar.LENGTH_SHORT).show()
//          idle()
//        }
//        ViewEvent.Loading -> {
//          loading()
//        }
//        is ViewEvent.Success<*> -> {
////          Timber.d(it.data.toString())
////          adapter.submitList( (it.data as PostsResponse).posts)
//          idle()
//        }
//      }
//    }
  }

  private fun loading() {
    binding.progressBar.visibility = View.VISIBLE
  }

  private fun idle() {
    binding.progressBar.visibility = View.GONE
  }

  private fun registerViewEvents() {
    adapter = PostListAdapter()
    binding.apply {
      recyclerView.setHasFixedSize(true)
      recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
        header = LoadingIndicatorAdapter { adapter.retry() },
        footer = LoadingIndicatorAdapter { adapter.retry() }
      )
    }
  }

  companion object {
    const val FETCHED_POSTS = 1
    const val FAILED_TO_FETCH_POSTS = 2
  }
}
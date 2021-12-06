package com.mohammadfayaz.postfeed.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mohammadfayaz.postfeed.databinding.FragmentPostFeedBinding
import com.mohammadfayaz.postfeed.utils.ViewEvent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PostFeedFragment : Fragment() {

  private val viewModel: PostFeedViewModel by viewModels()
  private lateinit var binding: FragmentPostFeedBinding

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
    viewModel.viewEvents.observe(viewLifecycleOwner) {
      when (it) {
        is ViewEvent.Idle -> {
          idle()
        }
        is ViewEvent.Error<*> -> {
          Snackbar.make(binding.root, it.error, Snackbar.LENGTH_SHORT).show()
          idle()
        }
        ViewEvent.Loading -> {
          loading()
        }
        is ViewEvent.Success<*> -> {
//          Timber.d(it.data.toString())
          idle()
        }
      }
    }
  }

  private fun loading() {
    binding.progressBar.visibility = View.VISIBLE
  }

  private fun idle() {
    binding.progressBar.visibility = View.GONE
  }

  private fun registerViewEvents() {

  }

  companion object {
    const val FETCHED_POSTS = 1
    const val FAILED_TO_FETCH_POSTS = 2
  }
}
package com.mohammadfayaz.postfeed.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mohammadfayaz.postfeed.databinding.FragmentPostFeedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFeedFragment : Fragment() {

  private val viewModel: PostFeedViewModel by viewModels()
  private lateinit var binding: FragmentPostFeedBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPostFeedBinding.inflate(layoutInflater)
    return binding.root
  }

}
package com.mohammadfayaz.postfeed.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mohammadfayaz.postfeed.R
import com.mohammadfayaz.postfeed.databinding.FragmentPostDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment : Fragment() {

  private val viewModel: PostDetailViewModel by viewModels()
  private lateinit var binding: FragmentPostDetailBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPostDetailBinding.inflate(layoutInflater)
    return binding.root
  }

}
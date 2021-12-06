package com.mohammadfayaz.postfeed.ui.adapter.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohammadfayaz.postfeed.data.models.posts.PostModel
import com.mohammadfayaz.postfeed.databinding.LayoutPostItemBinding

class PostViewHolder private constructor(private val binding: LayoutPostItemBinding) :
  RecyclerView.ViewHolder(binding.root) {

  fun bind(story: PostModel) {
    binding.authorNameTextView.text = "anonymous"
    binding.titleTextView.text = story.title
    binding.bodyTextView.text = story.body
  }

  companion object {
    fun from(parent: ViewGroup): PostViewHolder {
      return PostViewHolder(
        LayoutPostItemBinding.inflate(
          LayoutInflater.from(
            parent.context
          ),
          parent,
          false
        )
      )
    }
  }
}

package com.mohammadfayaz.postfeed.ui.adapter.posts

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mohammadfayaz.postfeed.data.models.posts.PostModel

class PostListAdapter :
  ListAdapter<PostModel, PostViewHolder>(PostDiffUtilCallBack()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    return PostViewHolder.from(parent)
  }

  override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}

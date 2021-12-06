package com.mohammadfayaz.postfeed.ui.adapter.posts

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.mohammadfayaz.postfeed.data.models.posts.PostModel

class PostListAdapter :
  PagingDataAdapter<PostModel, PostViewHolder>(PostDiffUtilCallBack()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    return PostViewHolder.from(parent)
  }

  override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    holder.bind(getItem(position)!!)
  }
}

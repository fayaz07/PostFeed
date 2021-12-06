package com.mohammadfayaz.postfeed.ui.adapter.posts

import androidx.recyclerview.widget.DiffUtil
import com.mohammadfayaz.postfeed.data.models.posts.PostModel

class PostDiffUtilCallBack : DiffUtil.ItemCallback<PostModel>() {
  override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
    return oldItem == newItem
  }
}

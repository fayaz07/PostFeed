package com.mohammadfayaz.postfeed.data.models.posts


import com.google.gson.annotations.SerializedName
import com.mohammadfayaz.postfeed.data.models.MetaModel

data class PostsResponse(
  @SerializedName("data")
  val posts: List<PostModel>,
  @SerializedName("meta")
  val meta: MetaModel
)
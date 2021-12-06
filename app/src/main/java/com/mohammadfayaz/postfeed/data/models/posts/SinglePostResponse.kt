package com.mohammadfayaz.postfeed.data.models.posts


import com.google.gson.annotations.SerializedName

data class SinglePostResponse(
  @SerializedName("data")
  val post: PostModel
)
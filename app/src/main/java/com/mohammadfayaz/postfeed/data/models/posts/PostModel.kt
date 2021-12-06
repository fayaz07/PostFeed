package com.mohammadfayaz.postfeed.data.models.posts


import com.google.gson.annotations.SerializedName

data class PostModel(
  @SerializedName("body")
  val body: String,
  @SerializedName("id")
  val id: Int,
  @SerializedName("title")
  val title: String,
  @SerializedName("user_id")
  val userId: Int
)
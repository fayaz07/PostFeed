package com.mohammadfayaz.postfeed.data.models.comments


import com.google.gson.annotations.SerializedName

data class CommentModel(
  @SerializedName("body")
  val body: String,
  @SerializedName("email")
  val email: String,
  @SerializedName("id")
  val id: Int,
  @SerializedName("name")
  val name: String,
  @SerializedName("post_id")
  val postId: Int
)
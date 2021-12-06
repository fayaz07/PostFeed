package com.mohammadfayaz.postfeed.data.models.comments


import com.google.gson.annotations.SerializedName
import com.mohammadfayaz.postfeed.data.models.MetaModel

data class CommentsResponse(
  @SerializedName("data")
  val comments: List<CommentModel>,
  @SerializedName("meta")
  val meta: MetaModel
)
package com.mohammadfayaz.postfeed.data.models


import com.google.gson.annotations.SerializedName

data class LinksModel(
  @SerializedName("current")
  val current: String,
  @SerializedName("next")
  val next: String,
  @SerializedName("previous")
  val previous: Any?
)
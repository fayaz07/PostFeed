package com.mohammadfayaz.postfeed.data.models

import com.google.gson.annotations.SerializedName

data class PaginationModel(
  @SerializedName("limit")
  val limit: Int,
  @SerializedName("links")
  val links: LinksModel,
  @SerializedName("page")
  val page: Int,
  @SerializedName("pages")
  val pages: Int,
  @SerializedName("total")
  val total: Int
)
package com.mohammadfayaz.postfeed.data.models

import com.google.gson.annotations.SerializedName

data class MetaModel(
  @SerializedName("pagination")
  val pagination: PaginationModel
)
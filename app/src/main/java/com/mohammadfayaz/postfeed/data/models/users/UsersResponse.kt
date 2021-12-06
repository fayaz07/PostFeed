package com.mohammadfayaz.postfeed.data.models.users

import com.google.gson.annotations.SerializedName
import com.mohammadfayaz.postfeed.data.models.MetaModel

data class UsersResponse(
  @SerializedName("data")
  val users: List<UserModel>,
  @SerializedName("meta")
  val meta: MetaModel
)
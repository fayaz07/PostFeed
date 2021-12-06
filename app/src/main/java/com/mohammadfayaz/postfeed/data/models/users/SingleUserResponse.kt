package com.mohammadfayaz.postfeed.data.models.users


import com.google.gson.annotations.SerializedName

data class SingleUserResponse(
  @SerializedName("data")
  val user: UserModel
)
package com.mohammadfayaz.postfeed.data.models.posts

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//@Parcelize
//@Entity(tableName = Constants.postsTable)
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
//  : Parcelable
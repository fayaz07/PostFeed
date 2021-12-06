package com.mohammadfayaz.postfeed.network.api

import com.mohammadfayaz.postfeed.data.models.posts.PostsResponse
import com.mohammadfayaz.postfeed.data.models.posts.SinglePostResponse
import com.mohammadfayaz.postfeed.data.models.users.SingleUserResponse
import com.mohammadfayaz.postfeed.data.models.users.UsersResponse
import com.mohammadfayaz.postfeed.network.EndPoints
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostFeedAPI {
  @GET(EndPoints.POSTS)
  suspend fun getPosts(@Query("page") page: Int): Response<PostsResponse>

  @GET(EndPoints.USERS)
  suspend fun getUsers(@Query("page") page: Int): Response<UsersResponse>

  @GET(EndPoints.USER_BY_ID)
  suspend fun getUserById(@Path("id") id: Int): Response<SingleUserResponse>

  @GET(EndPoints.POST_BY_ID)
  suspend fun getPostById(@Path("id") id: Int): Response<SinglePostResponse>
}

package com.mohammadfayaz.postfeed.domain.repository

import com.mohammadfayaz.postfeed.data.models.posts.PostsResponse
import com.mohammadfayaz.postfeed.network.api.PostFeedAPI
import retrofit2.Response
import javax.inject.Inject

class PostFeedRepo @Inject constructor(private val api: PostFeedAPI) {

  suspend fun fetchPosts(page: Int = 1): Response<PostsResponse> {
    return api.getPosts(page);
  }

}

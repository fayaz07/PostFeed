package com.mohammadfayaz.postfeed.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mohammadfayaz.postfeed.data.models.ApiResult
import com.mohammadfayaz.postfeed.data.models.posts.PostModel
import com.mohammadfayaz.postfeed.domain.DataConfig
import com.mohammadfayaz.postfeed.domain.paging.PostsPagingSource
import com.mohammadfayaz.postfeed.network.api.PostFeedAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostFeedRepo @Inject constructor(private val api: PostFeedAPI) {

  private suspend fun fetchPosts(page: Int = 1): ApiResult<List<PostModel>> {

    try {
      val response = api.getPosts(page)
      if (response.isSuccessful) {
        if (response.body() != null) {
          return ApiResult(response.body()!!.posts, true, "")
        }
      }
      return ApiResult(null, false, "Unable to fetch data")
    } catch (e: Exception) {
      return ApiResult(null, false, "Error: ${e.localizedMessage}")
    }
  }

  fun getPaginatedFlow(): Flow<PagingData<PostModel>> = Pager(
    config = PagingConfig(
      initialLoadSize = 1,
      pageSize = DataConfig.MAX_ITEMS_LIMIT,
      enablePlaceholders = false
    ),
    pagingSourceFactory = { PostsPagingSource(::fetchPosts) }
  ).flow

}

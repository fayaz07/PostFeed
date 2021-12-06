package com.mohammadfayaz.postfeed.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mohammadfayaz.postfeed.data.models.ApiResult
import com.mohammadfayaz.postfeed.data.models.posts.PostModel
import com.mohammadfayaz.postfeed.domain.DataConfig.START_PAGE_INDEX
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber

class PostsPagingSource(
  private val getItems: suspend (Int) -> ApiResult<List<PostModel>>
) :
  PagingSource<Int, PostModel>() {
  override fun getRefreshKey(state: PagingState<Int, PostModel>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      val anchorPage = state.closestPageToPosition(anchorPosition)
      anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostModel> {
    return try {
      withContext(Dispatchers.Default) {
        val currentPage = params.key ?: START_PAGE_INDEX
        Timber.d("Curr page: $currentPage")
        val list = mutableListOf<PostModel>()

        val response = getItems(currentPage)
//        delay(3000)
        if(response.success) {
          response.data?.let { list.addAll(it) }
          Timber.d("Sending ${list.size} posts")
          LoadResult.Page(
            data = list,
            prevKey = if (currentPage == START_PAGE_INDEX) null else currentPage - 1,
            nextKey = if (list.isEmpty()) null else currentPage + 1
          )
        }else{
          LoadResult.Error(Exception(response.message))
        }
      }
    } catch (e: Exception) {
      LoadResult.Error(e)
//      throw e
    }
  }
}

package com.mohammadfayaz.postfeed.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammadfayaz.postfeed.domain.repository.PostFeedRepo
import com.mohammadfayaz.postfeed.ui.feed.PostFeedFragment.Companion.FAILED_TO_FETCH_POSTS
import com.mohammadfayaz.postfeed.ui.feed.PostFeedFragment.Companion.FETCHED_POSTS
import com.mohammadfayaz.postfeed.utils.ViewEvent
import com.mohammadfayaz.postfeed.utils.error
import com.mohammadfayaz.postfeed.utils.load
import com.mohammadfayaz.postfeed.utils.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PostFeedViewModel @Inject constructor(private val repo: PostFeedRepo) : ViewModel() {

  private val _viewState = MutableLiveData<ViewEvent>()
  val viewEvents: LiveData<ViewEvent> = _viewState

  init {
    fetchPosts()
  }

  private fun fetchPosts() {
    viewModelScope.launch {
      _viewState.load()
      try {
        val response = repo.fetchPosts()
        _viewState.success(response.body(),"Fetched posts", FETCHED_POSTS)
      }catch (e: Exception){
        _viewState.error(e.localizedMessage, FAILED_TO_FETCH_POSTS, null)
      }
    }
  }
}
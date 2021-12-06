package com.mohammadfayaz.postfeed.di

import com.mohammadfayaz.postfeed.domain.repository.PostFeedRepo
import com.mohammadfayaz.postfeed.network.api.PostFeedAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

  @Provides
  @Singleton
  fun postFeedRepo(api: PostFeedAPI) = PostFeedRepo(api)

}

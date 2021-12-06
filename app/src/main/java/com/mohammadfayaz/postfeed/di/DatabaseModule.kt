//package com.mohammadfayaz.postfeed.di
//
//import android.content.Context
//import com.mohammadfayaz.postfeed.data.db.PostFeedDB
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class DatabaseModule {
//  @Provides
//  @Singleton
//  fun provideDatabase(@ApplicationContext context: Context) =
//    PostFeedDB.getInstance(context)
//
//  @Provides
//  @Singleton
//  fun postDao(db: PostFeedDB) = db.postDao()
//
//}

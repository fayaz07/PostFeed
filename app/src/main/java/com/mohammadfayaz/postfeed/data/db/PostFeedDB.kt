//package com.mohammadfayaz.postfeed.data.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.mohammadfayaz.postfeed.data.db.converters.ListConverters
//import com.mohammadfayaz.postfeed.data.db.dao.PostDao
//import com.mohammadfayaz.postfeed.data.models.posts.PostModel
//import com.mohammadfayaz.postfeed.utils.Constants
//
//@Database(
//  entities = [PostModel::class],
//  version = 1,
//  exportSchema = false
//)
//@TypeConverters(
//  *[ListConverters::class]
//)
//abstract class PostFeedDB : RoomDatabase() {
//
//  abstract fun postDao(): PostDao
//
//  companion object {
//    fun getInstance(context: Context): PostFeedDB {
//      return Room.databaseBuilder(
//        context.applicationContext,
//        PostFeedDB::class.java,
//        Constants.db
//      )
//        .build()
//    }
//  }
//}

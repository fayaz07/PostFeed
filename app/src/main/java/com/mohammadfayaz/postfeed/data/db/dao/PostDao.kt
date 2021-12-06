package com.mohammadfayaz.postfeed.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.mohammadfayaz.postfeed.data.models.posts.PostModel

@Dao
interface PostDao : BaseDao<PostModel> {
  @Query("SELECT * FROM posts WHERE id = :id")
  suspend fun getById(id: Int): PostModel?
}

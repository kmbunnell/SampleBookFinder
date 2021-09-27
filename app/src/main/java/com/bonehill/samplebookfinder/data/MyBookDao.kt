package com.bonehill.samplebookfinder.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyBookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (book:MyBook)

    @Query("SELECT * from MyBook ORDER BY title ASC")
    fun getItems(): Flow<List<MyBook>>
}
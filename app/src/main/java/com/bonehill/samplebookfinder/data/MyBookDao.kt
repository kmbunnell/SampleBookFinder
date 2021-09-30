package com.bonehill.samplebookfinder.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MyBookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (book:MyBook)

    @Query("SELECT * from MyBook ORDER BY title ASC")
    fun getItems(): Flow<List<MyBook>>

    @Transaction
    @Query("SELECT * FROM MyBook ORDER BY title ASC")
    fun getBooksWithTags(): Flow<List<BooksWithTags>>



}
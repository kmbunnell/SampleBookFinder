package com.bonehill.samplebookfinder.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyBook")
data class MyBook(@PrimaryKey(autoGenerate = true)
                  val id: Int = 0,
                  @ColumnInfo(name = "title")
                  val title:String,
                  @ColumnInfo(name = "thumbnail")
                  val thumbnail: String?) {

}
package com.bonehill.samplebookfinder.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tag")
data class Tag(@PrimaryKey(autoGenerate = true)
               val tagId: Int = 0,
               @ColumnInfo(name = "tagName")
               val tagName:String) {
}
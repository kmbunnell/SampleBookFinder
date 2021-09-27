package com.bonehill.samplebookfinder.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Tag(@PrimaryKey(autoGenerate = true)
               val id: Int = 0,
               @ColumnInfo(name = "tagName")
               val tagName:String) {
}
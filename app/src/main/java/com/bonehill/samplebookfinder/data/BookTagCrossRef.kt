package com.bonehill.samplebookfinder.data

import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "BookTagCrossRef", primaryKeys = ["myBookId", "tagId"], indices=[Index("tagId")])
data class BookTagCrossRef(val myBookId: Int,
                           val tagId: Int) {
}
package com.bonehill.samplebookfinder.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation


data class BooksWithTags(
    @Embedded val myBook: MyBook,
    @Relation(
        parentColumn = "myBookId",
        entityColumn = "tagId",
        associateBy = Junction(BookTagCrossRef::class)
    )
    val tags: List<Tag>
)
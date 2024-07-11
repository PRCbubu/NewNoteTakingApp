package com.practicing.notetakingapp2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    val noteTitle: String,
    @ColumnInfo(name = "body")
    val noteBody: String
): Parcelable

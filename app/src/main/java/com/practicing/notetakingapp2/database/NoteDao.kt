package com.practicing.notetakingapp2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.practicing.notetakingapp2.model.NoteEntity

@Dao
interface NoteDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM notes order by id DESC")
    suspend fun getAllNotes(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE Title LIKE :searchQuery OR Body LIKE :searchQuery")
    fun searchNote(searchQuery: String): LiveData<List<NoteEntity>>

}
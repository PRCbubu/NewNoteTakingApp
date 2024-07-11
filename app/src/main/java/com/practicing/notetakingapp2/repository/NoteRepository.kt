package com.practicing.notetakingapp2.repository

import com.practicing.notetakingapp2.database.NoteDatabase
import com.practicing.notetakingapp2.model.NoteEntity

class NoteRepository(private val db: NoteDatabase)
{
    suspend fun insertNote(note: NoteEntity) = db.noteDao().insertNote(note)
    suspend fun updateNote(note: NoteEntity) = db.noteDao().updateNote(note)
    suspend fun deleteNote(note: NoteEntity) = db.noteDao().deleteNote(note)

    fun getAllNotes() = db.noteDao().getAllNotes()
    fun searchNote(query: String?) = db.noteDao().searchNote(query)
}
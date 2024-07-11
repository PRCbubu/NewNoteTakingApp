package com.practicing.notetakingapp2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.practicing.notetakingapp2.model.NoteEntity
import com.practicing.notetakingapp2.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository): AndroidViewModel(app)
{
    fun insertNote(note: NoteEntity) = viewModelScope.launch { noteRepository.insertNote(note) }
    fun updateNote(note: NoteEntity) = viewModelScope.launch { noteRepository.updateNote(note) }
    fun deleteNote(note: NoteEntity) = viewModelScope.launch { noteRepository.deleteNote(note) }
    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNote(query: String?) = noteRepository.searchNote(query)
}
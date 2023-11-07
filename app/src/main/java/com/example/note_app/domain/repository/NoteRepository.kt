package com.example.note_app.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.note_app.domain.model.Note

interface NoteRepository {
    fun getNotes():Flow<List<Note>>

    suspend fun addNote(note:Note)

    suspend fun updateNote(note:Note)

    suspend fun deleteNote(note:Note)
    suspend fun getNote(id: Int):Note?

}
package com.example.note_app.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.note_app.domain.model.Note

interface NoteRepository {
    fun getNote():Flow<List<Note>>

    suspend fun addNote(note:Note)

    suspend fun update(note:Note)

    suspend fun delete(note:Note)
}
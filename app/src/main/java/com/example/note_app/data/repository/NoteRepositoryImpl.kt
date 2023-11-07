package com.example.note_app.data.repository

import com.example.note_app.data.data_source.NoteDao
import com.example.note_app.domain.model.Note
import com.example.note_app.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> = noteDao.getNotes()

    override suspend fun addNote(note: Note) = noteDao.addNote(note)

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    override suspend fun getNote(id: Int) = noteDao.getNote(id)

}
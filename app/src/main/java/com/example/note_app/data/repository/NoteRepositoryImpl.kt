package com.example.note_app.data.repository

import com.example.note_app.data.data_source.NoteDao
import com.example.note_app.domain.model.Note
import com.example.note_app.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getNote(): Flow<List<Note>> = noteDao.getNote()

    override suspend fun add(note: Note) = noteDao.add(note)

    override suspend fun update(note: Note) = noteDao.update(note)

    override suspend fun delete(note: Note) = noteDao.delete(note)
}
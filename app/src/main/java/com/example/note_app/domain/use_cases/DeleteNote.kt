package com.example.note_app.domain.use_cases

import com.example.note_app.domain.model.Note
import com.example.note_app.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = noteRepository.deleteNote(note)

}
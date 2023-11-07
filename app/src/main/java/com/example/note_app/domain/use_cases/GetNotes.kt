package com.example.note_app.domain.use_cases

import com.example.note_app.domain.repository.NoteRepository

class GetNotes (
    val noteRepository: NoteRepository
){
    suspend operator fun invoke() = noteRepository.getNotes()

}
package com.example.note_app.presentation.nodes

import com.example.note_app.domain.model.Note

sealed class NoteEvent {
    data class DeleteNote(val note: Note) : NoteEvent()
    object RestoreNote : NoteEvent()
}
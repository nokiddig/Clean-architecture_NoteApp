package com.example.note_app.presentation.util

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    object SaveNote : AddEditNoteEvent()
}
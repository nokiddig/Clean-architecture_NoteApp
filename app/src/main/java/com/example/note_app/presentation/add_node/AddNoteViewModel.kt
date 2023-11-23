package com.example.note_app.presentation.add_node

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app.domain.model.Note
import com.example.note_app.domain.use_cases.NoteUseCases
import com.example.note_app.presentation.util.AddEditNoteEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel(){

    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle

    private val _noteContent = mutableStateOf("")
    val noteContent: State<String> = _noteContent

    fun onEvent(event: AddEditNoteEvent){
        when(event){
            is AddEditNoteEvent.EnteredTitle
                -> {_noteTitle.value = event.value}
            is AddEditNoteEvent.EnteredTitle
                -> {_noteContent.value = event.value}
            is AddEditNoteEvent.SaveNote
                -> {viewModelScope.launch {
                    noteUseCases.addNote(Note(
                        title = noteTitle.value,
                        content = noteContent.value,
                        timestamp = System.currentTimeMillis()
                    ))
            }}

            else -> {}
        }
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.note_app.presentation.nodes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun NoteScreen(navController: NavController,
               noteViewModel: NotesViewModel = hiltViewModel()) {
    val notes = noteViewModel.noteState.value
    val scaffoldState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")})
        },
        snackbarHost = { SnackbarHost(scaffoldState)}
    ) {
        Spacer(
            modifier = Modifier
                .height(
                    16.dp
                )
                .padding(it)
        )
        LazyColumn(modifier = Modifier.fillMaxHeight()){
            items(notes) {
                note -> NoteItem(note = note, modifier = Modifier.fillMaxWidth(),
                    onDelete = {
                        noteViewModel.onEvent(NoteEvent.DeleteNote(note))
                        scope.launch {
                            val result = scaffoldState.showSnackbar(
                                message = "Note deleted",
                                actionLabel = "Undo"
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                noteViewModel.onEvent(NoteEvent.RestoreNote)
                            }
                        }
                    })
            }
        }
    }
}
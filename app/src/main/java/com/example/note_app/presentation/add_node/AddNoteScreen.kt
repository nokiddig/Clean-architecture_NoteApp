@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.note_app.presentation.add_node

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.note_app.presentation.util.AddEditNoteEvent

@Composable
fun AddNoteScreen(
    navController: NavController,
    viewModel: AddNoteViewModel = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value
    val scaffoldState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (titleState.isBlank()){
                        Toast.makeText(context,"Title is empty",Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    if (contentState.isBlank()){
                        Toast.makeText(context,"Content is empty",Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
                    navController.navigateUp()
                },
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primary),
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Save note"
                )
            }
        },
        snackbarHost = {SnackbarHost(scaffoldState)}
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp).padding(it)
        ) {
            OutlinedTextField(
                value = titleState,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Title") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = contentState,
                onValueChange = {
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                },
                singleLine = false,
                textStyle = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxSize().padding(bottom = 60.dp),
                label = { Text("Content") }

            )

        }
    }
}
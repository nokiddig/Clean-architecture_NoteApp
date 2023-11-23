package com.example.note_app.presentation.nodes

import androidx.compose.material3.MaterialTheme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.note_app.domain.model.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp).padding(end = 32.dp)
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                maxLines = 5
            )
        }
        IconButton(
            onClick = onDelete,
            modifier=Modifier.align(Alignment.CenterEnd)
        ){
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete note"
            )
        }
    }
}
package com.bahanh.note.ui.addeditnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(note: Note?, onSaveNote: (Note) -> Unit, navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(title = { /*TODO*/ }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }, actions = {
            IconButton(onClick = { onSaveNote(Note()) }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Note")
            }
        })
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(text = "Header")
            Text(text = "Content")
        }
    }
}
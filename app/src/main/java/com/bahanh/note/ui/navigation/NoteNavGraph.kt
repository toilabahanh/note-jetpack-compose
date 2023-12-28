package com.bahanh.note.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bahanh.note.data.Note
import com.bahanh.note.ui.addeditnote.AddEditNoteScreen
import com.bahanh.note.ui.notes.NotesScreen

@Composable
fun NoteNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(navController = navController, startDestination = Screens.NOTE_SCREEN, modifier) {
        composable(Screens.NOTE_SCREEN) {
            NotesScreen(
                onAddNote = { /*TODO*/ },
                onSearchClick = { /*TODO*/ },
                onInformationClick = { /*TODO*/ },
                onNoteClick = {
                    navController.navigate(Screens.ADD_EDIT_NOTE_SCREEN)
                },
                onNoteLongClick = {},
            )
        }
        composable(route = Screens.ADD_EDIT_NOTE_SCREEN) {
            val note = Note(id = "1", "Title", "Content")
            AddEditNoteScreen(note = note, onSaveNote = {
                navController.navigateUp()
            }, navController)
        }
    }

}
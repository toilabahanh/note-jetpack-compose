package com.bahanh.note

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bahanh.note.ui.navigation.NoteNavGraph

@Composable
fun NoteApp(navController: NavHostController = rememberNavController()) {
    NoteNavGraph(navController = navController)
}
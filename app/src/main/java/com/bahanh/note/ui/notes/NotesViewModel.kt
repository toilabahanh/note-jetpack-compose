package com.bahanh.note.ui.notes

data class NotesUIState(
    val items: List<Note> = emptyList(),
    val isLoading: Boolean = false,
)
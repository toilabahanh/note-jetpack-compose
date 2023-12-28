package com.bahanh.note.ui.note

import com.bahanh.note.data.Note

data class NoteUiState(
    val noteDetails: NoteDetails = NoteDetails(),
)

data class NoteDetails(
    val id: String = "1",
    val title: String = "",
    val content: String = ""
)


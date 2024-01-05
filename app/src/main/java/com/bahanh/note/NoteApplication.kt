package com.bahanh.note

import android.app.Application
import com.bahanh.note.data.NotesDatabase

class NoteApplication: Application() {
    val database by lazy { NotesDatabase.getDatabase(this) }
}
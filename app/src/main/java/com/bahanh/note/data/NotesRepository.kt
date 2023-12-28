package com.bahanh.note.data

import kotlinx.coroutines.flow.Flow


interface NotesRepository {
    fun getAllNotesStream(): Flow<List<Note>>

    fun getNoteStream(id: String): Flow<Note?>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)
}
package com.bahanh.note.data

import kotlinx.coroutines.flow.Flow

class OfflineNotesRepository(private val noteDao: NoteDao) {
    fun getAllItemsStream(): Flow<List<Note>> = noteDao.getNotes()
    suspend fun getItemStream(id: String): Note? = noteDao.getNote(id)
    suspend fun insertItem(title: String, content: String) = noteDao.createNote(title, content)
    suspend fun deleteItem(id: String) = noteDao.deleteNote(id)
    suspend fun updateItem(id: String, title: String, content: String) =
        noteDao.updateNote(id, title, content)
}
package com.bahanh.note.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query ("SELECT * FROM notes")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * From notes WHERE id = :id")
    suspend fun getNote(id: String): Note?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createNote(title: String, content: String): String

    @Update
    suspend fun updateNote(id: String, title: String, content: String)

    @Delete
    suspend fun deleteNote(id: String)

    suspend fun deleteAllNote()
}
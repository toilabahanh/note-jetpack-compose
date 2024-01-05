package com.bahanh.note.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bahanh.note.data.Note
import com.bahanh.note.data.NoteDao
import kotlinx.coroutines.launch

class NotesViewModel(private val itemDao: NoteDao): ViewModel() {
    private fun insertItem(title: String, content: String) {
        viewModelScope.launch {
            itemDao.createNote(title, content)
        }
    }
}

class NoteViewModelFactory(private val itemDao: NoteDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
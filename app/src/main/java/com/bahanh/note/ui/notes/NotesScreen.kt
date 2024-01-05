package com.bahanh.note.ui.notes

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bahanh.note.R
import com.bahanh.note.data.Note
import com.bahanh.note.ui.theme.NoteTheme
import com.bahanh.note.util.LoadingContent
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    onAddNote: () -> Unit,
    onSearchClick: () -> Unit,
    onInformationClick: () -> Unit,
    onNoteClick: (Note) -> Unit,
    onNoteLongClick: (Note) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Note", maxLines = 1, overflow = TextOverflow.Ellipsis) },
            actions = {
                IconButton(onClick = { onSearchClick() }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(onClick = { onInformationClick() }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "Information")
                }
            })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onAddNote() }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add new note")
        }
    }) {
        Box(modifier = Modifier.padding(20.dp), contentAlignment = Alignment.Center) {
            NotesContent(
                loading = false, notes = listOf(
                    Note("1", "Note 1", "Content 1"),
                    Note("2", "Note 2", "Content 2"),
                    Note("3", "Note 3", "Content 3"),
                    Note("4", "Note 4", "Content 4"),
                    Note("5", "Note 5", "Content 5"),
                    Note("6", "Note 6", "Content 6"),
                    Note("7", "Note 7", "Content 7"),
                    Note("8", "Note 8", "Content 8"),
                ), onNoteClick, onNoteLongClick
            )
        }

    }
}

@Composable
fun NotesContent(
    loading: Boolean?,
    notes: List<Note>,
    onNoteClick: (Note) -> Unit,
    onNoteLongClick: (Note) -> Unit
) {
    LoadingContent(empty = false, emptyContent = { NoteEmptyItem() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(notes) { note ->
                    NoteItem(note, onNoteClick, onNoteLongClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteItem(noteItem: Note, onNoteClick: (Note) -> Unit, onNoteLongClick: (Note) -> Unit) {
    val backgroundColor = Color(
        red = Random.nextInt(256), green = Random.nextInt(256), blue = Random.nextInt(256), 80
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onNoteClick(noteItem) },
                onLongClick = { onNoteLongClick(noteItem) })
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .defaultMinSize(minHeight = 80.dp)
                .clip(shape = MaterialTheme.shapes.large)
                .background(backgroundColor),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "1231123",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.displaySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun NoteEmptyItem() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Using SVG File
//        val svgRequest = ImageRequest.Builder(LocalContext.current).data(R.raw.empty_illustration)
//            .build()
//        val svgPainter = rememberAsyncImagePainter(
//            model = svgRequest
//        )
//
//        Image(
//            painter = svgPainter,
//            contentDescription = "Empty Component",
//        )

        Image(
            painter = painterResource(id = R.raw.empty),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )

        Text(text = "Create your first note!", style = MaterialTheme.typography.titleMedium)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUI() {
    NoteTheme {
        Surface {
            NotesScreen(
                onAddNote = {},
                onSearchClick = {},
                onInformationClick = {},
                onNoteClick = {},
                onNoteLongClick = {}
            )
        }
    }
}
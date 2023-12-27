package com.bahanh.note.notes

import android.annotation.SuppressLint
import android.content.res.AssetManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.bahanh.note.R
import com.bahanh.note.ui.theme.NoteTheme

@Composable
fun NotesScreen() {
}

@Composable
fun NotesContent() {
}

@Composable
fun NoteItem() {

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
            NoteEmptyItem()
        }
    }
}
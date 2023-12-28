package com.bahanh.note.util

import androidx.compose.runtime.Composable

@Composable
fun LoadingContent(empty: Boolean, emptyContent:  @Composable () -> Unit, content: @Composable () -> Unit) {
    if(empty) emptyContent() else content()
}
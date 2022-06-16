package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsListScreen(
    onItemCLick: (Result) -> Unit,
    newsList: List<Result>
) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(newsList) { newsItem ->
            NewsItem(newsItem)
        }
    }
}

@Composable
fun NewsItem(newsItem: Result?) {
    Text(text = newsItem?.title.orEmpty())
}
package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.alexilinskiy.nytimescomposeapp.model.Result

@Composable
fun NewsListScreen(
    onItemCLick: (Result) -> Unit,
    newsList: LazyPagingItems<Result>
) {
    LazyColumn {
        items(newsList) { newsItem ->
            NewsItem(newsItem)
        }
    }
}

@Composable
fun NewsItem(newsItem: Result?) {
    Text(text = newsItem?.title.orEmpty())
}
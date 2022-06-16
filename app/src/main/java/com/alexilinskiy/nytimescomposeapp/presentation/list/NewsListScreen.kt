package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
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
fun NewsItem(newsItem: Result) {
    Row(
        modifier = Modifier.fillMaxWidth()

    ) {
        GlideImage(
            imageModel = newsItem.multimedia.first().url,
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(0.2f)
                .padding(8.dp),
            requestOptions = {
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
            },
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier.weight(0.8f)
                .padding(start = 8.dp)
        ) {
            Text(text = newsItem.title)
        }
    }
}
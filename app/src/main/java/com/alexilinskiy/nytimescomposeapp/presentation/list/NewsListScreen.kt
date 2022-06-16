package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
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
    Scaffold(
        topBar = {
            TopAppBar {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu"
                    )
                }
                Text(text = "Top stories from New York Times")
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite News"
                    )
                }
            }
        },
        content = {
            NewsList(newsList, onItemCLick)
        }
    )
}

@Composable
fun NewsList(newsList: List<Result>, onItemCLick: (Result) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(newsList) { newsItem ->
            NewsItem(newsItem, onItemCLick)
        }
    }
}

@Composable
fun NewsItem(newsItem: Result, onItemCLick: (Result) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable { onItemCLick(newsItem) }

    ) {
        GlideImage(
            imageModel = newsItem.multimedia.first().url,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .weight(0.2f)
                .padding(8.dp),
            requestOptions = {
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
            },
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .weight(0.8f)
                .padding(start = 8.dp)
        ) {
            Text(text = newsItem.title)
        }
    }
}
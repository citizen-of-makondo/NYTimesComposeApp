package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.alexilinskiy.nytimescomposeapp.model.Section
import com.alexilinskiy.nytimescomposeapp.model.SectionList
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun NewsListScreen(
    onItemDrawerClick: (Section) -> Unit,
    onItemCLick: (Result) -> Unit,
    newsList: List<Result>
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn {
                items(SectionList.sections) {
                    DrawerItem(it, onItemDrawerClick)
                }
            }
        },
        topBar = {
            TopAppBar(backgroundColor = Color.Gray.copy(alpha = 0.5f)) {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu"
                    )
                }
                Text(
                    text = "Top stories from New York Times",
                    color = Color.Black
                )
            }
        },
        content = {
            NewsList(newsList, onItemCLick)
        }
    )
}

@Composable
fun DrawerItem(sectionItem: Section, onItemDrawerClick: (section: Section) -> Unit) {
    val color = if (sectionItem.isChecked) Color.Blue else Color.Black
    Box(
        modifier = Modifier
            .clickable { onItemDrawerClick(sectionItem) }
            .padding(horizontal = 10.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = sectionItem.showName,
            fontSize = 16.sp,
            color = color
        )
    }
}

@Composable
fun NewsList(newsList: List<Result>, onItemCLick: (Result) -> Unit) {
    LazyColumn {
        items(newsList) { newsItem ->
            if (newsItem.title.isNotEmpty()) {
                NewsItem(newsItem, onItemCLick)
            }
        }
    }
}

@Composable
fun NewsItem(newsItem: Result, onItemCLick: (Result) -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
            .clickable { onItemCLick(newsItem) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            imageModel = newsItem.multimedia?.last()?.url,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .weight(0.2f)
                .padding(start = 4.dp)
                .size(80.dp),
            requestOptions = {
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .centerCrop()
            },
            alignment = Alignment.Center,
            failure = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "no image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .weight(0.8f)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = newsItem.title
            )
        }
    }
}
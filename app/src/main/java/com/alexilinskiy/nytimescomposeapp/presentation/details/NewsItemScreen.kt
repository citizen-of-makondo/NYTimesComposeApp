package com.alexilinskiy.nytimescomposeapp.presentation.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsItemScreen(item: Result) {
    Column {
        ImageItem(item)
        ContentItem(item)
    }
}

@Composable
fun ImageItem(newsItem: Result) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        GlideImage(
            imageModel = newsItem.multimedia?.first()?.url,
            contentScale = ContentScale.Fit,
            /* modifier = Modifier
                 .fillMaxSize(),*/
            requestOptions = {
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .centerCrop()
            },
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
    }
}

@Composable
fun ContentItem(item: Result) {
    Column {
        Text(
            text = item.title,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = item.abstract,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 16.sp
        )
    }
}

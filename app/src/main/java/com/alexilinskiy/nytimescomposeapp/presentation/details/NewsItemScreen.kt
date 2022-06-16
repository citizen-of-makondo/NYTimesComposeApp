package com.alexilinskiy.nytimescomposeapp.presentation.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.alexilinskiy.nytimescomposeapp.model.Result

@Composable
fun NewsItemScreen(item: Result) {
    Text(text = item.title)

}
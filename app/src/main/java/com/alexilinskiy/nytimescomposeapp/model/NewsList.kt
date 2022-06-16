package com.alexilinskiy.nytimescomposeapp.model

data class NewsList(
    val nextPage: Int,
    val results: List<Result>,
    val status: String,
    val totalResults: Int
)
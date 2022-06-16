package com.alexilinskiy.nytimescomposeapp.model

import com.google.gson.annotations.SerializedName

data class Result(
    val category: List<String>,
    val content: String,
    val country: List<String>,
    val creator: List<String>,
    val description: String,
    @SerializedName("full_description")
    val fullDescription: String,
    @SerializedName("image_url")
    val imageUrl: Any,
    val keywords: List<String>,
    val language: String,
    val link: String,
    val pubDate: String,
    @SerializedName("source_id")
    val sourceId: String,
    val title: String,
    val video_url: Any
)
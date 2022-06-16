package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsList

interface NewsRepository {

    suspend fun getWorldNews(page: Int): NewsList

}
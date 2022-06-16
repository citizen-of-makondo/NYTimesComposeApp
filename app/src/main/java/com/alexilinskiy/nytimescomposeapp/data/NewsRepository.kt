package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsResult

interface NewsRepository {

    suspend fun getDefaultNews(): NewsResult

}
package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsResult
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    companion object {
        const val apiKey = "QhB0E7H0o640FOKQNVd7IdgDCuu4n9Dn"
    }

    override suspend fun getDefaultNews(): NewsResult = newsApi.getWorldNews(apiKey)
}
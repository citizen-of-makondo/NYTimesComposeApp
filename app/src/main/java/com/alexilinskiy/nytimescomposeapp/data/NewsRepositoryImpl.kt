package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsList
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsRepository {

    private val apiKey = "pub_604275edaeddb976cff3d9d408659367c250"

    private val WORLD_CATEGORY = "world"

    override suspend fun getWorldNews(page: Int): NewsList {
        val data = newsApi.getWorldNews(
            apiKey = apiKey,
            category = WORLD_CATEGORY,
            page = page
        )
        return data.copy(results = data.results.filter { it.language == "english" })
    }
}
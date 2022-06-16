package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("1/news")
    suspend fun getWorldNews(
        @Query("apikey") apiKey: String,
        @Query("category") category: String,
        @Query("page") page: Int
    ): NewsList

}
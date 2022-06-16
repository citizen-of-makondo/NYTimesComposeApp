package com.alexilinskiy.nytimescomposeapp.data

import com.alexilinskiy.nytimescomposeapp.model.NewsResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("home.json")
    suspend fun getWorldNews(
        @Query("api-key") apiKey: String
    ): NewsResult

    @GET("{section}.json")
    suspend fun getSectionNews(
        @Path("section") section: String,
        @Query("api-key") apiKey: String
    ): NewsResult

}
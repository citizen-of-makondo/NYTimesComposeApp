package com.alexilinskiy.nytimescomposeapp.di

import com.alexilinskiy.nytimescomposeapp.data.NewsApi
import com.alexilinskiy.nytimescomposeapp.data.NewsRepository
import com.alexilinskiy.nytimescomposeapp.data.NewsRepositoryImpl
import com.alexilinskiy.nytimescomposeapp.domain.PagingSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsdata.io/api/")
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun providePagingSource(repository: NewsRepository): PagingSource {
        return PagingSource(repository)
    }

    @Singleton
    @Provides
    fun provideRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

}
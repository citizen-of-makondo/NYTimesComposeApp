package com.alexilinskiy.nytimescomposeapp.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexilinskiy.nytimescomposeapp.data.NewsRepository
import javax.inject.Singleton
import com.alexilinskiy.nytimescomposeapp.model.Result

@Singleton
class PagingSource(
    private val repository: NewsRepository
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val repos = repository.getWorldNews(page)
            LoadResult.Page(
                data = repos.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
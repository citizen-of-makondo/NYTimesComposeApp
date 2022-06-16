package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alexilinskiy.nytimescomposeapp.domain.PagingSource
import com.alexilinskiy.nytimescomposeapp.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val pagingSource: PagingSource,
) : ViewModel() {

    val newsList: Flow<PagingData<Result>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { pagingSource }).flow

}
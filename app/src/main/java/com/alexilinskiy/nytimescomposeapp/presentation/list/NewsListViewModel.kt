package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexilinskiy.nytimescomposeapp.data.NewsRepository
import com.alexilinskiy.nytimescomposeapp.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    var news = mutableStateOf(emptyList<Result>())

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            news.value = repository.getDefaultNews().results
        }

    }
}
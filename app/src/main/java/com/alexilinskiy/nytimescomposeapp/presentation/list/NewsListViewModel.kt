package com.alexilinskiy.nytimescomposeapp.presentation.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexilinskiy.nytimescomposeapp.data.NewsRepository
import com.alexilinskiy.nytimescomposeapp.model.Result
import com.alexilinskiy.nytimescomposeapp.model.Section
import com.alexilinskiy.nytimescomposeapp.model.SectionList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    var news = mutableStateOf(emptyList<Result>())

    var sections = mutableStateOf(SectionList.sections)

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            news.value = repository.getDefaultNews().results
        }

    }

    fun getSectionNews(section: Section) {
        sections.value.map {
            it.isChecked = it == section
        }
        viewModelScope.launch {
            news.value = repository.getSectionNews(section.requestName).results
        }
    }
}
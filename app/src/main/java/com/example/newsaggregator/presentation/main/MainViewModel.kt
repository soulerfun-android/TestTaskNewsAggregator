package com.example.newsaggregator.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.domain.usecases.ShowNewsListUseCase
import com.example.newsaggregator.presentation.NewsListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val showNewsListUseCase: ShowNewsListUseCase
) : ViewModel() {

    private val _newsItemsState = MutableStateFlow<NewsListScreenState>(NewsListScreenState.Initial)
    val newsItemsState = _newsItemsState.asStateFlow()

    init {
        viewModelScope.launch {
            getNewsList()
        }
    }

    suspend fun getNewsList() {
        val newsList = showNewsListUseCase.getNewsItemsList()
        _newsItemsState.value = NewsListScreenState.NewsListList(newsList)
    }
}
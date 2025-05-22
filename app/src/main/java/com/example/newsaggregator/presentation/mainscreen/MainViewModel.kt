package com.example.newsaggregator.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.data.rss.repository.RepositoryImpl
import com.example.newsaggregator.domain.usecases.ShowNewsListUseCase
import com.example.newsaggregator.presentation.NewsListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val repository = RepositoryImpl()
    private val showNewsListUseCase = ShowNewsListUseCase(repository)

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

//        val rssDto = RssFactory.rssFeedService.getRss()
//        val newsItems = mapper.mapDtoItemToEntity(rssDto)
//        _newsItemsState.value = NewsListScreenState.NewsListList(newsItems)
    }
}
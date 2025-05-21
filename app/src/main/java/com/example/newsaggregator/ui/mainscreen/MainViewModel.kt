package com.example.newsaggregator.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.data.rss.mapper.Mapper
import com.example.newsaggregator.data.rss.network.RssFactory
import com.example.newsaggregator.ui.screens.NewsListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val mapper = Mapper()

    private val _newsItemsState = MutableStateFlow<NewsListScreenState>(NewsListScreenState.Initial)
    val newsItemsState = _newsItemsState.asStateFlow()

    init {
        viewModelScope.launch {
            getNewsList()
        }
    }

    suspend fun getNewsList() {
        val rssDto = RssFactory.rssFeedService.getRss()
        val newsItems = mapper.mapDtoItemToEntity(rssDto)
        _newsItemsState.value = NewsListScreenState.NewsListList(newsItems)
    }
}
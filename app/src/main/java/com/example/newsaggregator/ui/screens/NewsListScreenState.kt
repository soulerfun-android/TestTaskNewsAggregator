package com.example.newsaggregator.ui.screens

import com.example.newsaggregator.domain.entity.NewsItem

sealed class NewsListScreenState {

    object Initial : NewsListScreenState()

    data class NewsListList(
        val newsList: List<NewsItem>
    ) : NewsListScreenState()
}
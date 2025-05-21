package com.example.newsaggregator.ui.screens

import com.example.newsaggregator.domain.entity.NewsItem

sealed class NewsScreenState {
    object Initial : NewsScreenState()

    data class NewsListList(
        val newsList: NewsItem
    ) : NewsScreenState()
}
package com.example.newsaggregator.domain

import com.example.newsaggregator.domain.entity.NewsItem

interface Repository {
    suspend fun getNewsItemsList(): List<NewsItem>
}
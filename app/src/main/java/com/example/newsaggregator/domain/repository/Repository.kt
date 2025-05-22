package com.example.newsaggregator.domain.repository

import com.example.newsaggregator.domain.entity.NewsItem

interface Repository {
    suspend fun getNewsItemsList(): List<NewsItem>
}
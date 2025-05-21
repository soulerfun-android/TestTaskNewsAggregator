package com.example.newsaggregator.domain.usecases

import com.example.newsaggregator.domain.Repository
import com.example.newsaggregator.domain.entity.NewsItem

class ShowNewsListUseCase(
    private val repository: Repository
) {
    suspend fun getNewsItemsList(): List<NewsItem> {
        return repository.getNewsItemsList()
    }
}
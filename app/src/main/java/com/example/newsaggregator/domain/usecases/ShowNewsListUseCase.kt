package com.example.newsaggregator.domain.usecases

import com.example.newsaggregator.domain.repository.Repository
import com.example.newsaggregator.domain.entity.NewsItem
import javax.inject.Inject

class ShowNewsListUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getNewsItemsList(): List<NewsItem> {
        return repository.getNewsItemsList()
    }
}
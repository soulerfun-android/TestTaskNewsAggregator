package com.example.newsaggregator.data.rss.repository

import com.example.newsaggregator.data.rss.mapper.Mapper
import com.example.newsaggregator.data.rss.network.RssFactory
import com.example.newsaggregator.data.rss.network.RssFeedService
import com.example.newsaggregator.domain.Repository
import com.example.newsaggregator.domain.entity.NewsItem

class RepositoryImpl(
    private val mapper: Mapper,
    private val rssFeedService: RssFeedService
) : Repository {
    override suspend fun getNewsItemsList(): List<NewsItem> {
        val rssDto = RssFactory.rssFeedService.getRss()
        return mapper.mapDtoItemToEntity(rssDto)
    }
}
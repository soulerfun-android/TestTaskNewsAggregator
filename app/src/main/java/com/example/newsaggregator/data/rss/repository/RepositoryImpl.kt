package com.example.newsaggregator.data.rss.repository

import com.example.newsaggregator.data.rss.mapper.Mapper
import com.example.newsaggregator.data.rss.network.RssFactory
import com.example.newsaggregator.data.rss.network.RssFeedService
import com.example.newsaggregator.domain.repository.Repository
import com.example.newsaggregator.domain.entity.NewsItem


class RepositoryImpl (
) : Repository {

    private val mapper: Mapper = Mapper()
    private val rssFeedService: RssFeedService = RssFactory.rssFeedService

    override suspend fun getNewsItemsList(): List<NewsItem> {
        val rssDto = rssFeedService.getRss()
        return mapper.mapDtoItemToEntity(rssDto)
    }
}
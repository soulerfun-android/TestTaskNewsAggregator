package com.example.newsaggregator.data.repository

import com.example.newsaggregator.data.mapper.Mapper
import com.example.newsaggregator.data.network.RssService
import com.example.newsaggregator.domain.repository.Repository
import com.example.newsaggregator.domain.entity.NewsItem
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val rssService: RssService
) : Repository {


    override suspend fun getNewsItemsList(): List<NewsItem> {
        val rssDto = rssService.getRss()
        return mapper.mapDtoItemToEntity(rssDto)
    }
}
package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.TextCleaner
import com.example.newsaggregator.data.rss.network.model.RssDto
import com.example.newsaggregator.domain.entity.NewsItem

class Mapper {
    fun mapDtoItemToEntity(rssDto: RssDto): List<NewsItem> {
        val newsItems = mutableListOf<NewsItem>()
        val urlList = mutableListOf<String>()
        var idCounter = 1

        rssDto.channel.items.forEach {
            it.contents.forEach {
                urlList.add(it.url)
            }
            newsItems.add(
                NewsItem(
                    title = it.title,
                    description = TextCleaner().cleanText(it.description),
                    url = urlList.get(idCounter),
                    guid = it.guid
                )
            )
            idCounter += 2

        }
        return newsItems
    }
}

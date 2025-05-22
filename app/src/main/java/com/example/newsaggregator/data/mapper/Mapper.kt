package com.example.newsaggregator.data.mapper

import com.example.newsaggregator.extentions.TextCleaner
import com.example.newsaggregator.data.network.model.RssDto
import com.example.newsaggregator.domain.entity.NewsItem
import javax.inject.Inject


class Mapper @Inject constructor() {
    fun mapDtoItemToEntity(rssDto: RssDto): List<NewsItem> {
        val newsItems = mutableListOf<NewsItem>()
        val urlList = mutableListOf<String>()
        var idCounter = ID

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
            idCounter += INCREASE_ID
        }
        return newsItems
    }

    companion object {
        private const val ID = 1
        private const val INCREASE_ID = 2
    }
}

package com.example.newsaggregator.presentation.navigation

import android.net.Uri
import com.example.newsaggregator.domain.entity.NewsItem

sealed class Screen(
    val route: String
) {
    object NewsList : Screen(ROUTE_NEWS_LIST)
    object News : Screen(ROUTE_NEWS) {
        private const val ROUTE_FOR_ARGS = "news"
        fun getRouteWithArgs(newsItem: NewsItem): String {
            return "$ROUTE_FOR_ARGS/${Uri.encode(newsItem.guid)}"
        }
    }

    companion object {
        const val KEY_NEWS_ITEM_GUID = "news_item_guid"

        const val ROUTE_NEWS_LIST = "news_list"
        const val ROUTE_NEWS = "news/{$KEY_NEWS_ITEM_GUID}"
    }
}
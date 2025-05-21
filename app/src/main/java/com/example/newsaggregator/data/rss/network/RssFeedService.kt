package com.example.newsaggregator.data.rss.network

import com.example.newsaggregator.data.rss.network.model.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssFeedService {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}
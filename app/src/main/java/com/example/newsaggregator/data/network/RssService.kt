package com.example.newsaggregator.data.network

import com.example.newsaggregator.data.network.model.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssService {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}
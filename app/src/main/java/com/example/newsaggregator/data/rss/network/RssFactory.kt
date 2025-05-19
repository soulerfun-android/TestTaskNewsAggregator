package com.example.newsaggregator.data.rss.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType
import retrofit2.Retrofit

object RssFactory {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.theguardian.com")
        .addConverterFactory(
            XML.asConverterFactory(
                MediaType.get("application/xml; charset=UTF8")
            )
        ).build()

    val rssFeedService = retrofit.create(RssFeedService::class.java)
}
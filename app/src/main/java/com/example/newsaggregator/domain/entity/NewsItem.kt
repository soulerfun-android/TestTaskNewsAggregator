package com.example.newsaggregator.domain.entity

data class NewsItem(
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val guid: String = ""
)
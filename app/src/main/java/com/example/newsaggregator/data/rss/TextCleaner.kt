package com.example.newsaggregator.data.rss

class TextCleaner {
    fun cleanText(text: String): String {
        return text.replace(Regex("<[^>]+>|&[^;]+;"), "").trim()
    }
}
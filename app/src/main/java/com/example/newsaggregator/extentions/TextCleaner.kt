package com.example.newsaggregator.extentions

class TextCleaner {
    fun cleanText(text: String): String {
        return text.replace(Regex("<[^>]+>|&[^;]+;"), "").trim()
    }
}
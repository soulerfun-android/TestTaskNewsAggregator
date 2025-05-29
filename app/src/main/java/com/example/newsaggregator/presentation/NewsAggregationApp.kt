package com.example.newsaggregator.presentation

import android.app.Application
import com.example.newsaggregator.di.ApplicationComponent
import com.example.newsaggregator.di.DaggerApplicationComponent

class NewsAggregationApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}
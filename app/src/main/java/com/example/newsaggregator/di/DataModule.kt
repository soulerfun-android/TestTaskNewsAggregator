package com.example.newsaggregator.di

import com.example.newsaggregator.data.network.RssFactory
import com.example.newsaggregator.data.network.RssService
import com.example.newsaggregator.data.repository.RepositoryImpl
import com.example.newsaggregator.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {
        @ApplicationScope
        @Provides
        fun provideRssService(): RssService {
            return RssFactory.rssService
        }
    }
}
package com.example.newsaggregator.presentation.main.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsaggregator.domain.entity.NewsItem
import com.example.newsaggregator.presentation.NewsListScreenState
import com.example.newsaggregator.presentation.main.MainViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NewsScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues,
    onNewsClickListener: (newsItem: NewsItem) -> Unit
) {

    val screenState = viewModel.newsItemsState.collectAsState(NewsListScreenState.Initial)

    when (val currentState = screenState.value) {

        NewsListScreenState.Initial -> {
            LoadingScreen()
        }

        NewsListScreenState.Error -> {
            ErrorScreen {
                viewModel.getNewsList()
            }
        }

        is NewsListScreenState.NewsListList -> {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(currentState.newsList, key = { it.title }) { newsItem ->
                    NewsCard(newsItem) {
                        onNewsClickListener(newsItem)
                    }
                }
            }

        }
    }
}


@Composable
fun NewsCard(
    newsItem: NewsItem,
    onNewsClickListener: (newsItem: NewsItem) -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp),
        onClick = { onNewsClickListener(newsItem) }
    ) {
        Column {
            Text(
                text = newsItem.title,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = newsItem.description, modifier = Modifier.padding(6.dp))
            GlideImage(
                imageModel = newsItem.url
            )
        }
    }
}
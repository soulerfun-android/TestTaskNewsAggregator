package com.example.newsaggregator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsaggregator.domain.entity.NewsItem

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsListScreenContent: @Composable () -> Unit,
    newsScreenContent: @Composable (newsItem: NewsItem) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.NewsList.route
    ) {
        composable(route = Screen.NewsList.route) {
            newsListScreenContent()
        }
        composable(
            route = Screen.News.route,
            arguments = listOf(
                navArgument(Screen.KEY_NEWS_ITEM_GUID) {
                    type = NavType.StringType
                }
            )) { navBackStackEntry ->
            val newsItemGuid =
                navBackStackEntry.arguments?.getString(Screen.KEY_NEWS_ITEM_GUID) ?: ""
            newsScreenContent(NewsItem(guid = newsItemGuid))
        }
    }
}
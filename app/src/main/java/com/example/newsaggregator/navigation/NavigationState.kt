package com.example.newsaggregator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.newsaggregator.domain.entity.NewsItem

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateTo(newsItem: NewsItem) {
        navHostController.navigate(Screen.News.getRouteWithArgs(newsItem)) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}
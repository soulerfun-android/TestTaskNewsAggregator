package com.example.newsaggregator.ui.composable_screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.newsaggregator.navigation.AppNavGraph
import com.example.newsaggregator.navigation.Screen
import com.example.newsaggregator.navigation.rememberNavigationState

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {
    val navigationState = rememberNavigationState()

    AppNavGraph(
        navHostController = navigationState.navHostController,
        newsListScreenContent = {
            NewsScreen(paddingValues) {
                navigationState.navigateTo(it)
            }
        },
        newsScreenContent = {
            WebScreen(it.guid)
        }
    )
}
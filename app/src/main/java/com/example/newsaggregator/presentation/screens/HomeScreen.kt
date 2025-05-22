package com.example.newsaggregator.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.newsaggregator.presentation.mainscreen.MainViewModel
import com.example.newsaggregator.presentation.navigation.AppNavGraph
import com.example.newsaggregator.presentation.navigation.rememberNavigationState

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: MainViewModel
) {
    val navigationState = rememberNavigationState()

    AppNavGraph(
        navHostController = navigationState.navHostController,
        newsListScreenContent = {
            NewsScreen(viewModel = viewModel, paddingValues = paddingValues) {
                navigationState.navigateTo(it)
            }
        },
        newsScreenContent = {
            WebScreen(it.guid)
        }
    )
}
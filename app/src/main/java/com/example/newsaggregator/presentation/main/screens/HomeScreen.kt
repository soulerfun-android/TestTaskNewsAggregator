package com.example.newsaggregator.presentation.main.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsaggregator.navigation.AppNavGraph
import com.example.newsaggregator.navigation.rememberNavigationState
import com.example.newsaggregator.presentation.ViewModelFactory
import com.example.newsaggregator.presentation.main.MainViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModelFactory: ViewModelFactory
) {
    val navigationState = rememberNavigationState()

    val viewModel: MainViewModel = viewModel(
        factory = viewModelFactory
    )

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
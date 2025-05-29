package com.example.newsaggregator.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.newsaggregator.presentation.NewsAggregationApp
import com.example.newsaggregator.presentation.ViewModelFactory
import com.example.newsaggregator.presentation.main.screens.HomeScreen
import com.example.newsaggregator.theme.NewsAggregatorTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as NewsAggregationApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAggregatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(viewModelFactory = viewModelFactory, paddingValues = innerPadding)
                }
            }
        }
    }
}

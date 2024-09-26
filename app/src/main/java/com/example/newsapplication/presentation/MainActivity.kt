package com.example.newsapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.newsapplication.presentation.news_screen.NewsScreen
import com.example.newsapplication.presentation.news_screen.NewsScreenViewModel
import com.example.newsapplication.presentation.theme.NewsApplicationTheme
import com.example.newsapplication.utls.NavGraphSetup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    private val splashScreenViewModel by viewModels<NewsScreenViewModel>()
    override fun onCreate(savedInstanceState : Bundle?)
    {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            splashScreen.setKeepOnScreenCondition {splashScreenViewModel.splashScreen}
            NewsApplicationTheme{
                val navController = rememberNavController()
                NavGraphSetup(navController = navController)
            }
        }
    }
}

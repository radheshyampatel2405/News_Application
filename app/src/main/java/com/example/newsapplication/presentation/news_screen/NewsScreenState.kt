package com.example.newsapplication.presentation.news_screen

import com.example.newsapplication.domain.model.Article

data class NewsScreenState(
        val isLoading: Boolean = false,
        val articles: List<Article> = emptyList(),
        val error: String? = null,
        val isSearchBarVisible: Boolean= false,
        val selectedArticle: Article? = null,
        val category: String = "General",
        val searchQuery: String = ""
                          )
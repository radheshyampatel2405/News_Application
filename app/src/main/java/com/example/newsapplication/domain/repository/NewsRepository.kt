package com.example.newsapplication.domain.repository

import com.example.newsapplication.domain.model.Article
import com.example.newsapplication.utls.Resource

interface NewsRepository
{
    suspend fun getTopHeadlines(
            category : String
                ):Resource<List<Article>>

    suspend fun searchForNews(query : String) : Resource<List<Article>>
}
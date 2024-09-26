package com.example.newsapplication.repository

import com.example.newsapplication.data.remote.NewsApi
import com.example.newsapplication.domain.model.Article
import com.example.newsapplication.domain.repository.NewsRepository
import com.example.newsapplication.utls.Resource

// This is file where we will try and catch the data from the api if the is problem
// it will return an error message


class NewsRepositoryImpl(
    private val newsApi: NewsApi
                        ): NewsRepository{
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>>{
        return try {
            val response = newsApi.getBreakingNews(category = category)
            Resource.Success(response.articles)
        }catch (e: Exception){
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }

    override suspend fun searchForNews(query: String): Resource<List<Article>> {
        return try {
            val response = newsApi.searchForNews(query = query)
            Resource.Success(data = response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}
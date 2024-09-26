package com.example.newsapplication.data.remote

import com.example.newsapplication.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi
{
//     https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
//     This get request will return a response of type NewsResponse

    @GET("top-headlines")  // end point of the api
    suspend fun getBreakingNews(
//            @Query("country") countryCode : String= "us", // query parameters is USA
            @Query("category") category : String ,
            @Query("apiKey") apiKey : String = API_KEY
                               ): NewsResponse
    @GET("everything")
    suspend fun searchForNews(
            @Query("q") query: String,
            @Query("apiKey") apiKey: String = API_KEY
                             ): NewsResponse
    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "9ef95014235a4be8b57b5682cebd22af"
    }

}
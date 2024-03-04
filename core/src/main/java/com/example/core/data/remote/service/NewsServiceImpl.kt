package com.example.core.data.remote.service

import com.example.core.data.remote.HttpRoute
import com.example.core.data.remote.dto.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class NewsServiceImpl(private val httpClient: HttpClient) : NewsService {
    override suspend fun getTopHeadline(): NewsResponse {
        return httpClient.get {
            url(HttpRoute.TOP_HEADLINE_URL)
            parameter("country", "us")
        }.body()
    }
}
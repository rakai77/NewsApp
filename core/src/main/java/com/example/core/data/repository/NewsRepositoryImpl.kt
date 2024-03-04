package com.example.core.data.repository

import com.example.core.data.source.remote.dto.NewsResponse
import com.example.core.data.source.remote.service.NewsService
import com.example.core.domain.repository.NewsRepository

class NewsRepositoryImpl constructor(
    private val newsService: NewsService
) : NewsRepository {
    override suspend fun getTopHeadline(): NewsResponse {
        return newsService.getTopHeadline()
    }
}
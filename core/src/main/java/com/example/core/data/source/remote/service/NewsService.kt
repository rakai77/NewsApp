package com.example.core.data.source.remote.service

import com.example.core.data.source.remote.dto.NewsResponse

interface NewsService {

    suspend fun getTopHeadline() : NewsResponse
}
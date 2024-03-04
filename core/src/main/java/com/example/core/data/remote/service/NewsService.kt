package com.example.core.data.remote.service

import com.example.core.data.remote.dto.NewsResponse

interface NewsService {

    suspend fun getTopHeadline() : NewsResponse
}
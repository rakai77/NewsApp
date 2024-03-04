package com.example.core.domain.repository

import com.example.core.data.source.remote.dto.NewsResponse

interface NewsRepository {
    suspend fun getTopHeadline() : NewsResponse
}
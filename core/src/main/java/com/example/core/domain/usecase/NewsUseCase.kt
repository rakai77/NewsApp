package com.example.core.domain.usecase

import com.example.core.data.source.Resource
import com.example.core.data.source.remote.dto.NewsResponse
import com.example.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun getTopHeadline() : Flow<Resource<News>>
}
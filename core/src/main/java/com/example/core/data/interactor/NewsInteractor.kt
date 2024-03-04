package com.example.core.data.interactor

import com.example.core.data.source.Resource
import com.example.core.data.source.remote.SafeApiCall
import com.example.core.data.source.remote.mapper.toDomain
import com.example.core.domain.model.News
import com.example.core.domain.repository.NewsRepository
import com.example.core.domain.usecase.NewsUseCase
import com.example.core.utils.execute
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

class NewsInteractor constructor(
    private val coroutineContext: CoroutineContext,
    private val newsRepository: NewsRepository
) : NewsUseCase, SafeApiCall {
    override suspend fun getTopHeadline(): Flow<Resource<News>> {
        return execute(coroutineContext) {
            safeApiCall {
                newsRepository.getTopHeadline().run {
                    this.toDomain()
                }
            }
        }
    }
}
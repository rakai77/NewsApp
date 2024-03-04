package com.example.core.di

import com.example.core.data.repository.NewsRepositoryImpl
import com.example.core.data.source.remote.service.NewsService
import com.example.core.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideNewsRepository(newsService: NewsService) : NewsRepository = NewsRepositoryImpl(newsService)
}
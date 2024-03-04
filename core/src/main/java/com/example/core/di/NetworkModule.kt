package com.example.core.di

import com.example.core.data.source.remote.HttpClientFactory
import com.example.core.data.source.remote.service.NewsService
import com.example.core.data.source.remote.service.NewsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideHttpClient() : HttpClient = HttpClientFactory().create()

    @Provides
    fun provideNewsService(httpClient: HttpClient) : NewsService = NewsServiceImpl(httpClient)
}
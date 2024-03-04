package com.example.core.di

import com.example.core.data.interactor.NewsInteractor
import com.example.core.domain.repository.NewsRepository
import com.example.core.domain.usecase.NewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideNewsUseCase(newsRepository: NewsRepository) : NewsUseCase = NewsInteractor(Dispatchers.IO, newsRepository)
}
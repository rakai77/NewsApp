package com.example.newsapp.presentation.screen.home

import com.example.core.domain.model.News

sealed class HomeUiState {
    data class Success(val news: News) : HomeUiState()
    data class Error(val errorMessage: String) : HomeUiState()
    object Loading : HomeUiState()
    object Idle : HomeUiState()
}
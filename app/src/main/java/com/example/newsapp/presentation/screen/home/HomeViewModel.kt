package com.example.newsapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.source.Resource
import com.example.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val homeUiState get() = _homeUiState.asStateFlow()

    fun getTopHeadline() {
        viewModelScope.launch {
            _homeUiState.emit(HomeUiState.Loading)
            newsUseCase.getTopHeadline().collect { result ->
                when(result) {
                    is Resource.Success -> {
                        _homeUiState.emit(HomeUiState.Success(result.data))
                    }
                    is Resource.Error -> {
                        _homeUiState.emit(HomeUiState.Error(result.message))
                    }
                    else -> Unit
                }
            }
        }
    }
}
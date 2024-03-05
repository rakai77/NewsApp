package com.example.newsapp.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.domain.model.ArticlesItem
import com.example.newsapp.presentation.component.TopAppHeader

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onDetailClick: (ArticlesItem) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getTopHeadline()
    }

    val homeUiState by viewModel.homeUiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppHeader(
            modifier = Modifier.fillMaxWidth(),
            title = "Top Trending",
        )

        when(homeUiState) {
            is HomeUiState.Loading ->  {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(36.dp),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            is HomeUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val newsList = (homeUiState as HomeUiState.Success).news
                    items(newsList.articles ?: emptyList()) { news ->
                        NewsItems(
                            modifier = Modifier.fillMaxWidth(),
                            news = news,
                            onItemClick = {
                                onDetailClick.invoke(it)
                            }
                        )
                    }
                }
            }
            else -> Unit
        }
    }
}

@Composable
fun NewsItems(
    modifier: Modifier = Modifier,
    news: ArticlesItem,
    onItemClick: (ArticlesItem) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .clickable { onItemClick.invoke(news) },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            model = news.urlToImage,
            contentDescription = null
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .padding(horizontal = 8.dp),
            text = news.title ?: "",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
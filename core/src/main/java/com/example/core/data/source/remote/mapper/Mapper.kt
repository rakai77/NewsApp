package com.example.core.data.source.remote.mapper

import com.example.core.data.source.remote.dto.ArticlesItemResult
import com.example.core.data.source.remote.dto.NewsResponse
import com.example.core.data.source.remote.dto.SourceData
import com.example.core.domain.model.ArticlesItem
import com.example.core.domain.model.News
import com.example.core.domain.model.Source

fun NewsResponse.toDomain() = News(
    totalResults = this.totalResults ?: 0,
    articles = this.articles?.map { it.toDomain() } ?: emptyList(),
    status = this.status ?: ""
)

fun ArticlesItemResult.toDomain() = ArticlesItem(
    publishedAt = this.publishedAt,
    author = this.author,
    urlToImage = this.urlToImage,
    description = this.description,
    source = this.source?.toDomain(),
    title = this.title,
    url = this.url,
    content = this.content
)


fun SourceData.toDomain() = Source(
    id = this.id,
    name = this.name
)
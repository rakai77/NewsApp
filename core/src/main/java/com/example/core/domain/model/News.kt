package com.example.core.domain.model

import java.io.Serializable

data class News(
    val totalResults: Int? = null,
    val articles: List<ArticlesItem>? = null,
    val status: String
)

data class ArticlesItem(
    val publishedAt: String? = null,
    val author: String? = null,
    val urlToImage: String? = null,
    val description: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val content: String? = null
) : Serializable

data class Source(
    val name: String? = null,
    val id: String? = null
)


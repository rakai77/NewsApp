package com.example.core.data.source.remote.dto

data class NewsResponse(
	val totalResults: Int? = null,
	val articles: List<ArticlesItemResult>? = null,
	val status: String? = null
)

data class ArticlesItemResult(
	val publishedAt: String? = null,
	val author: String? = null,
	val urlToImage: String? = null,
	val description: String? = null,
	val source: SourceData? = null,
	val title: String? = null,
	val url: String? = null,
	val content: String? = null
)

data class SourceData(
	val name: String? = null,
	val id: String? = null
)


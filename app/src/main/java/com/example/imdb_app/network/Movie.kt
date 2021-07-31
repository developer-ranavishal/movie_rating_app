package com.example.imdb_app.network

data class Movie(
    val page: Int,
    val results: List<Results>,
    val total_pages: Int,
    val total_results: Int
)
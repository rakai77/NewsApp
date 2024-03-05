package com.example.newsapp.presentation.navigation

sealed class Route(val route: String) {

    object Home : Route("home")
    object Detail : Route("detail")
}
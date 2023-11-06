package com.example.navigation

sealed class NavigationFlow {
    object MovieListFlow : NavigationFlow()
    class MovieDetailFlow(val msg: String) : NavigationFlow()
}

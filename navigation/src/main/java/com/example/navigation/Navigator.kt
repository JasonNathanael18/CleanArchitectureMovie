package com.example.navigation

import androidx.navigation.NavController

class Navigator {
    lateinit var navController: NavController

     //navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.MovieListFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMovieListFlow())
        is NavigationFlow.MovieDetailFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMovieDetailFlow(navigationFlow.msg))
     }
}
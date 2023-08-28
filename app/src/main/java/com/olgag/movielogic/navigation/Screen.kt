package com.olgag.movielogic.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main")
    object PopularScreen : Screen("popular")
    object DetailsScreen : Screen("details")
}

package com.olgag.movielogic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olgag.movielogic.screens.ComposableDetailsScreen
import com.olgag.movielogic.screens.ComposableMainScreen
import com.olgag.movielogic.model.MovieViewModel
import com.olgag.movielogic.screens.ComposablePopularScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    viewModel: MovieViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            ComposableMainScreen(viewModel = viewModel, navController = navController)
        }

        composable(Screen.PopularScreen.route) {
            ComposablePopularScreen(viewModel = viewModel,  navController = navController)
        }

        composable(Screen.DetailsScreen.route) {
            ComposableDetailsScreen(viewModel = viewModel)
        }
    }
}

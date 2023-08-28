package com.olgag.movielogic.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.olgag.movielogic.components.MovieItem
import com.olgag.movielogic.model.MovieItem
import com.olgag.movielogic.model.MovieViewModel
import com.olgag.movielogic.navigation.Screen

@Composable
fun ComposableMainScreen(viewModel: MovieViewModel, navController: NavController){
    val movieListDB by viewModel.allMovieList.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.fetchMovie()

    }

    if (movieListDB.isEmpty()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.size(80.dp),
                color = Color.Gray,
                strokeWidth = 8.dp,
            )
        }
    } else {
        Column()
        {
            Row() {
                Button(onClick = {
                    navController.navigate(Screen.PopularScreen.route)
                }) {
                    Text("popular")
                }
            }
            LazyColumn() {
                items(movieListDB) { item: MovieItem ->
                    MovieItem(movie = item ,onItemClicked = {
                        viewModel.setMovieItem(item)
                        navController.navigate(Screen.DetailsScreen.route)
                    } )
                }
            }
        }
    }
}